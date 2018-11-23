/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.core.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;

import org.apache.commons.compress.compressors.brotli.BrotliCompressorInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import me.digi.sdk.core.config.ApiConfig;
import me.digi.sdk.core.entities.ErrorResponse;
import me.digi.sdk.core.errorhandling.DigiMeException;
import me.digi.sdk.crypto.ByteUtils;
import me.digi.sdk.crypto.CACryptoProvider;
import me.digi.sdk.crypto.CAKeyStore;
import me.digi.sdk.crypto.DGMCryptoFailureException;
import me.digi.sdk.crypto.FailureCause;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CAExtractContentInterceptor implements Interceptor {
    private final Gson gson = new Gson();
    private CACryptoProvider cryptoProvider;
    private boolean cryptoInitialized;

    private static final String CONTENT_KEY = "fileContent";
    private static final String COMPRESSION_KEY = "compression";

    public CAExtractContentInterceptor(CAKeyStore providerKeys) {
        cryptoInitialized = !providerKeys.isEmpty();
        cryptoProvider = new CACryptoProvider(providerKeys);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful() || response.body() == null)
            return response;

        LinkedTreeMap<String, Object> parsedMap;
        try {
            //noinspection ConstantConditions
            parsedMap = readAsTreeMap(response.peekBody(response.body().contentLength()).byteStream());
        } catch (Exception e) {
            return response;
        }

        byte[] decrypted = null;
        if (EncryptedPaths.shouldDecrypt(chain.request().url()) && hasEncryptedContent(parsedMap)) {
            if (!cryptoInitialized) {
                return response;
            }
            try {
                decrypted = decrypt(parsedMap);
            } catch (DGMCryptoFailureException dge) {
                return mapError("Decryption failure", "Failed to decrypt content", 411, response);
            }
        }

        String decryptedAndDecoded = null;
        if (hasCompressedContent(parsedMap)) {
            if (decrypted == null)
                decryptedAndDecoded = decode(parsedMap);
            else {
                //noinspection ConstantConditions
                decryptedAndDecoded = decodeBytes(compressedWith(parsedMap), decrypted);
            }
        } else if (decrypted != null) {
            decryptedAndDecoded = ByteUtils.bytesToString(decrypted);
        }

        if (TextUtils.isEmpty(decryptedAndDecoded))
            return response;

        String newBody = null;
        boolean stripFileContent = EncryptedPaths.isAccountsPath(response.request().url());
        try {
            if (!stripFileContent)
                newBody = updateAndReturnJson(CONTENT_KEY, decryptedAndDecoded, parsedMap);
            else
                newBody = gson.toJson(decryptedAndDecoded, JsonElement.class);
        } catch (Exception ex) {
            return response;
        }
        return buildNewResponse(response, newBody);
    }

    private Response buildNewResponse(Response originalResponse, String newBody) {
        String wantedContentType = originalResponse.header("Content-Type");
        if (TextUtils.isEmpty(wantedContentType)) {
            wantedContentType = "application/json";
        }
        return originalResponse.newBuilder()
            .body(ResponseBody.create(MediaType.parse(wantedContentType), newBody))
            .build();
    }

    /**
     *  Returns a custom error response so it can be correctly mapped and de-serialized to an exception in the client
     *  Primarily used to communicate decryption failure (since original response would throw a different exception)
     */
    private Response mapError(@NonNull String responseMessage, @NonNull String errorMessage, int code, @NonNull Response originalResponse) {
        if (code < 400) return originalResponse;
        ErrorResponse error = new ErrorResponse(responseMessage, errorMessage, "", code);
        return originalResponse.newBuilder()
                .code(code)
                .message(responseMessage)
                .body(ResponseBody.create(MediaType.parse("application/json"), gson.toJson(error, ErrorResponse.class)))
                .header("Content-Type", "application/json")
                .build();
    }

    private LinkedTreeMap<String, Object> readAsTreeMap(InputStream in) {
        return gson.fromJson(new JsonReader(new InputStreamReader(in)), Object.class);
    }

    /** Currently only {@link #CONTENT_KEY} value is encrypted */
    private boolean hasEncryptedContent(LinkedTreeMap treeMap) {
        return keyHasValue(CONTENT_KEY, treeMap);
    }

    /** Currently only {@link #CONTENT_KEY} value is compressed */
    private boolean hasCompressedContent(LinkedTreeMap treeMap) {
        return keyHasValue(CONTENT_KEY, treeMap) && !TextUtils.isEmpty(compressedWith(treeMap));
    }

    private boolean keyHasValue(String key, LinkedTreeMap treeMap) {
        return (treeMap.get(key) != null && (treeMap.get(key) instanceof String)
            && !((String)(treeMap.get(key))).isEmpty());
    }

    @Nullable
    private String compressedWith(LinkedTreeMap treeMap) {
        if (treeMap.get(COMPRESSION_KEY) != null && (treeMap.get(COMPRESSION_KEY) instanceof String))
            return ((String)(treeMap.get(COMPRESSION_KEY)));
        else
            return null;
    }

    private String decode(LinkedTreeMap<String, Object> parsedMap) {
        String decoded;
        try {
            String fileContent = (String) parsedMap.get(CONTENT_KEY);
            String compressedWith = compressedWith(parsedMap);
            if (TextUtils.isEmpty(compressedWith))
                decoded = fileContent;
            else
                decoded = decodeBytes(compressedWith, fileContent.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new DigiMeException("Problem decoding: "+e);
        }
        return decoded;
    }

    private String updateAndReturnJson(String key, String newValue, LinkedTreeMap<String, Object> parsedMap) {
        parsedMap.put(key, gson.fromJson(newValue, JsonElement.class));
        return gson.toJson(parsedMap);
    }

    private byte[] decrypt(LinkedTreeMap<String, Object> parsedMap) throws DGMCryptoFailureException {
        try {
            //We can assume the check has already passed at the call site
            String fileContent = (String) parsedMap.get(CONTENT_KEY);
            return cryptoProvider.decryptStream(new ByteArrayInputStream(fileContent.getBytes("UTF-8")));
        } catch (IOException | DGMCryptoFailureException | NullPointerException ex) {
            throw new DGMCryptoFailureException(FailureCause.RSA_DECRYPTION_FAILURE);
        }
    }

    private String decodeBytes(String compressedWith, byte[] compressedContent) throws IOException {
        if (!compressedWith.equals("brotli"))
            throw new DigiMeException("Unsupported compression algorithm: "+compressedWith);

        return decodeBrotli(compressedContent);
    }

    private String decodeBrotli(byte[] compressedContent) throws IOException {
        BrotliCompressorInputStream stream = new BrotliCompressorInputStream(new ByteArrayInputStream(compressedContent));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16];
        while ((nRead = stream.read(data)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        stream.close();

        return ByteUtils.bytesToString(buffer.toByteArray());
    }

    private static class EncryptedPaths {
        private static final String[] whitelist = {"v1/permission-access/query/_any_/_any_"};
        private static final ApiConfig thisApi = ApiConfig.get();
        private static final String ANY_MATCHER = "_any_";
        private static final String ACCOUNT_FILE = "accounts.json";

        static boolean shouldDecrypt(HttpUrl url) {
            boolean match = false;
            for (String pattern: whitelist) {
                HttpUrl template = HttpUrl.parse(thisApi.getUrl() + pattern);
                if (template == null || template.pathSegments().size() != url.pathSegments().size()) {
                    continue;
                }
                for (int i = 0; i < url.pathSegments().size(); i++) {
                    String templateSegment = template.pathSegments().get(i);
                    match = templateSegment.equals(ANY_MATCHER) ||
                            templateSegment.equals(url.pathSegments().get(i));
                    if (!match) break;
                }
                if (match) break;
            }
            return match;
        }

        static boolean isAccountsPath(HttpUrl url) {
            List<String> segments = url.pathSegments();
            return segments.get(segments.size() - 1).endsWith(ACCOUNT_FILE);
        }
    }
}
