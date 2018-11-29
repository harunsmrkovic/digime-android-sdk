package me.digi.sdk.models.music

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.music.TActor

class ActorSpec : ModelTest<Actor>(Actor::class.java) {
    override val emptyTest: Actor? = Actor(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Actor?, String>> =
            listOf(
                    Pair(
                            TActor.obj,
                            TActor.json
                    )
            )
}