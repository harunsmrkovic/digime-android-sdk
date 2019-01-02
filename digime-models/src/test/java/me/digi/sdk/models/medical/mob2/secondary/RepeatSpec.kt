/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TRepeat

class RepeatSpec : ModelTest<Repeat>(Repeat::class.java) {
    override val emptyTest: Repeat? = Repeat(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Repeat?, String>> =
            listOf(
                    Pair(
                            TRepeat.obj,
                            TRepeat.json
                    )
            )
}