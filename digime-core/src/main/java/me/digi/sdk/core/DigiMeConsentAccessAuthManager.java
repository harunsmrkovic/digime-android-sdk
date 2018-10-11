/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.core;

import android.content.Intent;
import android.support.annotation.Nullable;

import me.digi.sdk.core.session.CASession;

public class DigiMeConsentAccessAuthManager extends DigiMeBaseAuthManager<CASession> {

    private static final String PERMISSION_ACCESS_INTENT_ACTION = "android.intent.action.DIGI_PERMISSION_REQUEST";
    private static final String PERMISSION_ACCESS_INTENT_TYPE = "text/plain";
    private static final int REQUEST_CODE = 762;

    public int getRequestCode() {
        return REQUEST_CODE;
    }

    @Override
    protected Intent createAppIntent(CASession intentSession) {
        Intent appIntent = new Intent()
                .setPackage(DIGI_ME_PACKAGE_ID)
                .setAction(PERMISSION_ACCESS_INTENT_ACTION)
                .setType(PERMISSION_ACCESS_INTENT_TYPE);
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
        callback.succeeded(new SDKResponse<>(extractSession(), null));
    }
}
