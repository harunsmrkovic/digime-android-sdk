package me.digi.sdk.core;

import android.content.Intent;
import android.support.annotation.Nullable;

import me.digi.sdk.core.session.CASession;
import me.digi.sdk.core.session.SessionResult;

public class DigiMePostboxAuthManager extends DigiMeBaseAuthManager<SessionResult> {

    private static final String POSTBOX_AUTH_INTENT_ACTION = "android.intent.action.DIGI_POSTBOX_AUTH_REQUEST";
    private static final String POSTBOX_INTENT_TYPE = "text/plain";
    private static final String POSTBOX_ID_EXTRA = "postbox_id";
    private static final int REQUEST_CODE = 763;

    public int getRequestCode() {
        return REQUEST_CODE;
    }

    @Override
    protected Intent createAppIntent(CASession intentSession) {
        Intent appIntent = new Intent()
            .setPackage(DIGI_ME_PACKAGE_ID)
            .setAction(POSTBOX_AUTH_INTENT_ACTION)
            .setType(POSTBOX_INTENT_TYPE);
        if (intentSession != null) {
            appIntent.putExtra(KEY_SESSION_TOKEN, intentSession.getSessionKey())
                .putExtra(KEY_APP_ID, appId)
                .putExtra(KEY_APP_NAME, appName)
                .putExtra(KEY_SDK_VERSION, DigiMeSDKVersion.VERSION);
        }
        return appIntent;
    }

    @Override
    protected void handleSuccess(@Nullable Intent data) {
        if (data == null)
            throw new DigiMeException("PostboxAuthManager expects postbox id onSuccess");

        SessionResult sessionResult = new CreatePostboxSession(extractSession(), data.getStringExtra(POSTBOX_ID_EXTRA));
        callback.succeeded(new SDKResponse<>(sessionResult, null));
    }
}
