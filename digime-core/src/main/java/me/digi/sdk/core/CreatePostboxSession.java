/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */
package me.digi.sdk.core;

import me.digi.sdk.core.session.CASession;
import me.digi.sdk.core.session.SessionResult;


public class CreatePostboxSession implements SessionResult {

    public final CASession session;
    public final String postboxId;

    CreatePostboxSession(CASession session, String postboxId) {
        this.session = session;
        this.postboxId = postboxId;
    }

    @Override
    public CASession session() {
        return session;
    }

}
