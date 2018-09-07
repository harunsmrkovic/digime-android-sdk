package me.digi.sdk.core;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import me.digi.sdk.core.internal.AuthorizationException;
import me.digi.sdk.core.internal.ipc.AuthorizationResolver;
import me.digi.sdk.core.internal.ipc.DigiMeDirectResolver;
import me.digi.sdk.core.internal.ipc.DigiMeFirstInstallResolver;
import me.digi.sdk.core.session.CASession;
import me.digi.sdk.core.session.SessionManager;
import me.digi.sdk.core.session.SessionResult;

@SuppressWarnings("WeakerAccess")
public abstract class DigiMeBaseAuthManager<T extends SessionResult> {

    public static final String DIGI_ME_PACKAGE_ID = "me.digi.app3";

    protected static final String KEY_SESSION_TOKEN = "KEY_SESSION_TOKEN";
    protected static final String KEY_APP_ID = "KEY_APP_ID";
    protected static final String KEY_APP_NAME = "KEY_APP_NAME";
    protected static final String DEFAULT_UNKNOWN_APP_NAME = "Android SDK App";

    protected WeakReference<Activity> authActivity;
    protected AuthorizationResolver resolver;

    protected static final AtomicReference<DigiMeConsentAccessAuthManager.DigiMeAuthorizationState> authInProgress = new AtomicReference<>(DigiMeConsentAccessAuthManager.DigiMeAuthorizationState.IDLE);
    protected SDKCallback<T> callback;

    protected final String appId;
    protected String appName;
    protected final CASession session;
    protected final SessionManager<CASession> sManager;

    public DigiMeBaseAuthManager() {
        this(DigiMeClient.getApplicationId(), DigiMeClient.getApplicationName(), DigiMeClient.getInstance().getSessionManager());
    }

    public DigiMeBaseAuthManager(String applicationId, String applicationName, SessionManager<CASession> manager) {
        this.appId = applicationId;
        this.appName = applicationName;
        this.sManager = manager;
        this.session = null;
        verifyAppName();
    }

    public DigiMeBaseAuthManager(String applicationId, String applicationName, CASession session) {
        this.appId = applicationId;
        this.appName = applicationName;
        this.session = session;
        this.sManager = null;
        verifyAppName();
    }

    abstract public int getRequestCode();

    abstract protected Intent createAppIntent(CASession intentSession);

    abstract protected void handleSuccess(@Nullable Intent data);

    @SuppressWarnings("UnusedParameters")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == getRequestCode()) {
            if (resultCode == Activity.RESULT_OK) {
                handleSuccess(data);
            } else {
                callback.failed(new AuthorizationException("Access denied", extractSession(), AuthorizationException.Reason.ACCESS_DENIED));
            }
            cancelOngoingAuthorization();
        } else {
            callback.failed(new AuthorizationException("Access denied", null, AuthorizationException.Reason.WRONG_CODE));
        }
    }

    public <T extends SessionResult> void resolveAuthorizationPath(Activity activity, SDKCallback<T> callback, boolean overrideSessionCreate) {
        if (nativeClientAvailable(activity)) {
            resolver = new DigiMeDirectResolver();
        } else {
            resolver = new DigiMeFirstInstallResolver();
        }
        resolver.overrideSessionCreation(overrideSessionCreate);
        resolver.resolveAuthFlow(this, activity, callback);
    }

    public void beginAuthorization(Activity activity, SDKCallback<SessionResult> callback) {
        if (activity == null) {
            throw new IllegalArgumentException("Must set the activity to start the flow.");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Must set the callback.");
        }
        if (!activity.isFinishing()) {
            authActivity = new WeakReference<>(activity);
            prepareRequest(activity, callback);
        }
    }

    public void beginDeferredAuthorization(Activity activity, SDKCallback<SessionResult> callback) {
        if (activity == null) {
            throw new IllegalArgumentException("Must set the activity to start the flow.");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Must set the callback.");
        }
        if (!activity.isFinishing()) {
            if (!markInDeferredProgress()) {
                callback.failed(new AuthorizationException("Authorization already in progress! Explicitly call cancelOngoingAuthorization() to explictly restart authorization."));
                cancelOngoingAuthorization();
                return;
            }
            this.authActivity = new WeakReference<>(activity);
            this.callback = (SDKCallback<T>)callback;
            startInstallDigiMeFlow(activity);
        } else {
            callback.failed(new AuthorizationException("Activity in finished state!"));
            cancelOngoingAuthorization();
        }
    }

    public void protocolResolved() {
        if (isInProgress() || isDeferred()) {
            resolver.clientResolved(callback);
        }
    }

    public void cancelOngoingAuthorization() {
        if (isDeferred()) {
            callback.failed(new AuthorizationException("Authorization timed out while waiting for native client!"));
        }
        resolver.stop();
        clearProgress();
        resolver = null;
        this.authActivity = null;
        this.callback = null;
    }

    public boolean nativeClientAvailable(Activity activity) {
        Intent appIntent = createAppIntent(null);
        return verifyIntentCanBeHandled(appIntent, activity.getPackageManager());
    }

    private void prepareRequest(Activity activity, SDKCallback<SessionResult> callback) {
        CASession requestSession = extractSession();
        if (requestSession == null) {
            throw new NullPointerException("Session is null.");
        }
        if (!sendRequest(requestSession, activity, callback)) {
            callback.failed(new AuthorizationException("Authorization is already in progress.", requestSession, AuthorizationException.Reason.IN_PROGRESS));

        }
    }

    private boolean sendRequest(CASession session, Activity activity, SDKCallback<SessionResult> callback) {
        if (!markInProgress()) {
            return false;
        }
        this.callback = (SDKCallback<T>)callback;
        Intent sendIntent = createAppIntent(session);

        if (verifyIntentCanBeHandled(sendIntent, activity.getPackageManager())) {
            activity.startActivityForResult(sendIntent, getRequestCode());
        } else {
            startInstallDigiMeFlow(activity);
            return false;
        }
        return true;
    }

    protected CASession extractSession() {
        CASession requestSession = session;
        if (requestSession == null && sManager != null) {
            requestSession = sManager.getCurrentSession();
        }
        return requestSession;
    }

    private void verifyAppName() {
        if (TextUtils.isEmpty(appName)) {
            final PackageManager pm = DigiMeClient.getApplicationContext().getPackageManager();
            ApplicationInfo ai;
            try {
                ai = pm.getApplicationInfo(DigiMeClient.getApplicationContext().getPackageName(), 0);
            } catch (final PackageManager.NameNotFoundException e) {
                ai = null;
            }
            this.appName = ai != null ? (String) pm.getApplicationLabel(ai) : DEFAULT_UNKNOWN_APP_NAME;
        }
    }

    @SuppressWarnings("PackageManagerGetSignatures")
    private boolean verifyIntentCanBeHandled(Intent intent, PackageManager packageManager) {
        ResolveInfo resolveInfo = packageManager.resolveActivity(intent, 0);
        if (resolveInfo == null) {
            return false;
        }
        List activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (activities.size() == 0) {
            return false;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = packageManager.getPackageInfo(DIGI_ME_PACKAGE_ID, PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        //TODO reenable it! DIGI-3922
        /*
        for (Signature s : packageInfo.signatures) {
            if (!PackageSignatures.matchesSignature(s.toCharsString())) {
                return false;
            }
        }
        */
        return true;
    }

    private void startInstallDigiMeFlow(Activity activity) {
        try {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + DIGI_ME_PACKAGE_ID)));
        } catch (android.content.ActivityNotFoundException anfe) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + DIGI_ME_PACKAGE_ID)));
        }
        Toast.makeText(activity, "digi.me not found.", Toast.LENGTH_LONG).show();
    }

    private boolean markInProgress() {
        boolean result = false;
        if (isInProgress()) {
            Log.d(DigiMeClient.TAG, "Authorization is already in progress.");
        } else {
            authInProgress.set(DigiMeConsentAccessAuthManager.DigiMeAuthorizationState.IN_PROGRESS);
            result = true;
        }
        return result;
    }

    private boolean markInDeferredProgress() {
        boolean result = false;
        if (isInProgress() || isDeferred()) {
            Log.d(DigiMeClient.TAG, "Authorization is already in progress.");
        } else {
            authInProgress.set(DigiMeConsentAccessAuthManager.DigiMeAuthorizationState.DEFERRED);
            result = true;
        }
        return result;
    }

    private void clearProgress() {
        authInProgress.set(DigiMeConsentAccessAuthManager.DigiMeAuthorizationState.IDLE);
    }

    public boolean isInProgress() {
        return authInProgress.get() != null && authInProgress.get() == DigiMeConsentAccessAuthManager.DigiMeAuthorizationState.IN_PROGRESS;
    }

    public boolean isDeferred() {
        return authInProgress.get() != null && authInProgress.get() == DigiMeConsentAccessAuthManager.DigiMeAuthorizationState.DEFERRED;
    }

    public enum DigiMeAuthorizationState {
        IDLE,
        IN_PROGRESS,
        DEFERRED
    }

    // TODO re-enable DIGI-3922
    private static class PackageSignatures {
        static final String SANDBOX = "308201dd30820146020101300d06092a864886f70d010105050030373116301406035504030c0d416e64" +
            "726f69642044656275673110300e060355040a0c07416e64726f6964310b3009060355040613025553301e170d3136303330373134" +
            "323631305a170d3436303232383134323631305a30373116301406035504030c0d416e64726f69642044656275673110300e060355" +
            "040a0c07416e64726f6964310b300906035504061302555330819f300d06092a864886f70d010101050003818d0030818902818100" +
            "c03c99c49550c0967fdb8bf0b2b54544742d88b21bb249a9f77d563ef0e641f00568e862d594d17487454594cefe5d3da3352a365c" +
            "e454d945ba574c0716c8263e78f7f3e56582c3e30c88129cebbe92243bc52e2bfb79af18a869b6e355703d353e3feb2696d109d4b7" +
            "f647c13ea139fcfcf03c0b6289208dacab3bd4fca26b0203010001300d06092a864886f70d0101050500038181004fbd61e053f2da" +
            "a61918d10c3c26dd12de537561f95a09a97d888a1e34d45cb26c13da7212a15652809f9f55a6fe80cc27da0b3096a95b49d4c2d837" +
            "8412f1aca5d206f0e406f7f7000b48a8b02758c768bcfb62dccbf607bd2e755c5db3b785364efd90b5fbb528b634b38a5c55011bea" +
            "4c48a064b4950a5741addf0b7f3d10";

        static final String RELEASE = "3082019b30820104a003020102020456e6cd03300d06092a864886f70d0101050500301231103" +
            "00e060355040a1307446967692e6d65301e170d3136303331343134333835395a170d3431303330383134333835395a30123110300" +
            "e060355040a1307446967692e6d6530819f300d06092a864886f70d010101050003818d00308189028181008fbc2ca200aa72e4d0b" +
            "4ae78e6f93c1ebefd63fb1d5f9afeab1c459eb0de8eab7004fa2ecdfaabae0b6c734f0edbcf3d756c39e83e32d06a56750b619642c" +
            "90786b56c34a5a44692cb4334edb8c46ffac395eb5f16b2176fe2505ab9baa045cb0c7dbc48332947930aa1a8b7dd4713ac97b48f2" +
            "b67f3ed15dbd3438dde70e23f0203010001300d06092a864886f70d0101050500038181007d7efaedaa5c96cfabb57c86082dd6e13" +
            "a1fe72e201f2d394b06d279c0c19177d4a2e2fa17ddbea554600a23b226788659641b3cee3f4833df48043e4ac25d5513d1a3bac7e" +
            "dfc94ccc1e4ca33b4b0063e9d1cd150f79bd78757c000e8a5e4d165e120d24c2b8b94deb9f3b58e1f90ba54f901dbe3ca5a72ba2fe" +
            "9ebaf5d3140";
        static final String DEBUG ="308201dd30820146020101300d06092a864886f70d010105050030373116301406035504030c0d416e64726" +
            "f69642044656275673110300e060355040a0c07416e64726f6964310b3009060355040613025553301e170d3136313230313134323" +
            "032375a170d3436313132343134323032375a30373116301406035504030c0d416e64726f69642044656275673110300e060355040" +
            "a0c07416e64726f6964310b300906035504061302555330819f300d06092a864886f70d010101050003818d0030818902818100cc9" +
            "1c0b6c2df088b2503d574f9d2858a3cd3892ece238731cebf3da7b4d973d669e501f8138127a32a3531d5a954883245e9fb8ec4d66" +
            "b6a4b7d35bd88d009700adcb20e62631302b8a268073d3d94e7a26d9876cfad02d7e0638d312102afdc8804859aa145c2e2d8ec8d5" +
            "cf93a42ca1f6da4aac8e14b059aa34f83fcba3bed0203010001300d06092a864886f70d010105050003818100a12eae4a695dc3759" +
            "efc13a96cef07f43af426f7ab542c8f875b518921f0a757932a5350c51213518f01b26a020c742890c30fc67dbfce1d008c575da23" +
            "d0df1521269fef3a4ada19bb8a5f5b0d3e347c09684f8b58f23d3b3cb37b9bca25944c55d3274c718a101eeacb558960d65368af01" +
            "096c1b8d48a48ef4b56f0f8517a";

        static final String[] SIGNATURES = new String[] {RELEASE, DEBUG, SANDBOX};

        static boolean matchesSignature(String signature) {
            for (String SIGNATURE : SIGNATURES) {
                if (SIGNATURE.equals(signature)) {
                    return true;
                }
            }
            return false;
        }
    }
}
