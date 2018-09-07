package me.digi.sdk.core;

import android.content.Intent;
import android.support.annotation.Nullable;

import me.digi.sdk.core.session.CASession;

public class DigiMePostboxAuthManager extends DigiMeBaseAuthManager<CreatePostboxSession> {

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
                .putExtra(KEY_APP_NAME, appName);
        }
        return appIntent;
    }

    @Override
    protected void handleSuccess(@Nullable Intent data) {
        if (data == null)
            throw new DigiMeException("PostboxAuthManager expects postbox id onSuccess");
        callback.succeeded(new SDKResponse<>(new CreatePostboxSession(extractSession(), data.getStringExtra(POSTBOX_ID_EXTRA)), null));
    }
}
