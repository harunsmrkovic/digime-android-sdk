/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.music

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.music.TActor

class ActorSpec : ModelTest<Actor>(Actor::class.java) {
    override val emptyTest: Actor? = null

    override val jsonObjectTests: List<Pair<Actor?, String>> =
            listOf(
                    Pair(
                            TActor.obj,
                            TActor.json
                    )
            )
}