/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.core.internal.ipc;

import android.app.Activity;

import me.digi.sdk.core.DigiMeBaseAuthManager;
import me.digi.sdk.core.SDKCallback;
import me.digi.sdk.core.session.CASession;

public interface AuthorizationResolver {
    void resolveAuthFlow(DigiMeBaseAuthManager authManager, Activity activity, SDKCallback<CASession> authCallback);
    void clientResolved(SDKCallback<CASession> authCallback);
    void stop();
    void overrideSessionCreation(boolean shouldOverride);
}
