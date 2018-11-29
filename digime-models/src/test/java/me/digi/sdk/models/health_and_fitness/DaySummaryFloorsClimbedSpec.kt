/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class DaySummaryFloorsClimbedSpec : ModelTest<DaySummaryFloorsClimbed>(DaySummaryFloorsClimbed::class.java) {
    override val emptyTest: DaySummaryFloorsClimbed? = DaySummaryFloorsClimbed(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummaryFloorsClimbed?, String>> =
            listOf(
                    Pair(
                            DaySummaryFloorsClimbed(
                                    1,
                                    2
                            ),
                            """
                                {
                                    "floors":1,
                                    "goal":2
                                }
                            """.trimIndent()
                    )
            )
}