package me.digi.sdk.core.internal.ipc;

import android.app.Activity;
import android.content.Intent;

import me.digi.sdk.core.DigiMeBaseAuthManager;
import me.digi.sdk.core.DigiMeClient;
import me.digi.sdk.core.SDKCallback;
import me.digi.sdk.core.internal.quark.QuarkBrowserActivity;
import me.digi.sdk.core.session.CASession;
import me.digi.sdk.core.session.SessionResult;


public class DigiMeWebAuthResolver implements AuthorizationResolver {
    private boolean shouldOverride = false;

    @Override
    public <T extends SessionResult> void resolveAuthFlow(DigiMeBaseAuthManager authManager, Activity activity, SDKCallback<T> authCallback) {
        if (!shouldOverride) {
            DigiMeClient.getInstance().createSession(authCallback);
        } else {
            authManager.beginAuthorization(activity, authCallback);

            /** Note resolvesActivityInternally = true
                so beginAuthorization will not send the request itself so we do that here: */
            final Intent intent = new Intent(activity, QuarkBrowserActivity.class);
            CASession realSession = authManager.extractSession();
            intent.putExtra(QuarkBrowserActivity.EXTRA_SESSION_KEY, realSession.sessionKey);
            activity.startActivityForResult(intent, authManager.getRequestCode());
        }
    }

    @Override
    public <T extends SessionResult> void clientResolved(SDKCallback<T> authCallback) {  } // Not required

    @Override
    public void stop() { }  // Nothing to do

    @Override
    public void overrideSessionCreation(boolean shouldOverride) {
        this.shouldOverride = shouldOverride;
    }

    @Override
    public boolean resolvesActivityInternally() {
        return true;
    }
}
