package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class DaySummaryDistanceSpec : ModelTest<DaySummaryDistance>(DaySummaryDistance::class.java, object : ModelParam<DaySummaryDistance> {
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
                                            Distance(
                                                    "dummyActivity",
                                                    1.5f
                                            )
                                    ),
                                    2.5f
                            ),
                            """
                                {
                                    "totalDistance":1.5,
                                    "distances":[
                                        {
                                            "activity":"dummyActivity",
                                            "distance":1.5
                                        }
                                    ],
                                    "goal":2.5
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<DaySummaryDistance?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})