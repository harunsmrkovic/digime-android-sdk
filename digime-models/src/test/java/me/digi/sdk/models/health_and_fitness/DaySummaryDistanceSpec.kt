/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.health_and_fitness.TDistance

class DaySummaryDistanceSpec : ModelTest<DaySummaryDistance>(DaySummaryDistance::class.java) {
    override val emptyTest: DaySummaryDistance? = DaySummaryDistance(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummaryDistance?, String>> =
            listOf(
                    Pair(
                            DaySummaryDistance(
                                    1.5f,
                                    listOf(
                                            TDistance.obj
                                    ),
                                    2.5f
                            ),
                            """
                                {
                                    "totalDistance":1.5,
                                    "distances":[
                                        ${TDistance.json}
                                    ],
                                    "goal":2.5
                                }
                            """.trimIndent()
                    )
            )
}