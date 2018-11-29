/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class DaySummaryStepsSpec : ModelTest<DaySummarySteps>(DaySummarySteps::class.java) {
    override val emptyTest: DaySummarySteps? = DaySummarySteps(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummarySteps?, String>> =
            listOf(
                    Pair(
                            DaySummarySteps(
                                    1,
                                    2
                            ),
                            """
                                {
                                    "steps":1,
                                    "goal":2
                                }
                            """.trimIndent()
                    )
            )
}