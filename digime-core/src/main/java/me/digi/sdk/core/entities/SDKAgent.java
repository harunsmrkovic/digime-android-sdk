/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */
package me.digi.sdk.core.entities;

import android.os.Build;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import me.digi.sdk.core.DigiMeSDKVersion;
import me.digi.sdk.core.errorhandling.DigiMeException;


public class SDKAgent implements Serializable {

    @SerializedName("name")
    public final String platform;

    @SerializedName("version")
    public String version;

    // anything else that may be useful
    @SerializedName("meta")
    public String metaJson;

    public SDKAgent() {
        platform = "android";
        version = parseVersion(DigiMeSDKVersion.VERSION);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("device", Build.MODEL);
        jsonObject.addProperty("osVersion", Build.VERSION.RELEASE);
        metaJson = jsonObject.toString();
    }

    private String parseVersion(String versionCode) {
        Pattern pattern = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)");
        Matcher matcher = pattern.matcher(versionCode);
        if (matcher.lookingAt())
            return matcher.group();
        else
            throw new DigiMeException("Failed to parse valid version String from: "+versionCode);
    }

}
