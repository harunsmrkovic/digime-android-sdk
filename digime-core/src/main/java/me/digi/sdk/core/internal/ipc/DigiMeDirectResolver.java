/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.core.internal.ipc;

import android.app.Activity;

import me.digi.sdk.core.DigiMeBaseAuthManager;
import me.digi.sdk.core.DigiMeConsentAccessAuthManager;
import me.digi.sdk.core.DigiMeClient;
import me.digi.sdk.core.DigiMePostboxAuthManager;
import me.digi.sdk.core.SDKCallback;
import me.digi.sdk.core.session.CASession;

public class DigiMeDirectResolver implements AuthorizationResolver {
    private boolean shouldOverride = false;

    @Override
    public void resolveAuthFlow(DigiMeBaseAuthManager authManager, Activity activity, SDKCallback<CASession> authCallback) {
        if (!shouldOverride) {
            if (authManager instanceof DigiMeConsentAccessAuthManager)
                DigiMeClient.getInstance().createSession(authCallback);
            else if (authManager instanceof DigiMePostboxAuthManager)
                DigiMeClient.getInstance().createPostboxSession(authCallback);
        } else {
            authManager.beginAuthorization(activity, authCallback);
        }
    }

    @Override
    public void clientResolved(SDKCallback<CASession> authCallback) { }

    @Override
    public void stop() { }

    @Override
    public void overrideSessionCreation(boolean shouldOverride) {
        this.shouldOverride = shouldOverride;
    }
}
