package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class DaySummaryHeartRateSpec : ModelTest<DaySummaryHeartRate>(DaySummaryHeartRate::class.java) {
    override val emptyTest: DaySummaryHeartRate? = DaySummaryHeartRate(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummaryHeartRate?, String>> =
            listOf(
                    Pair(
                            DaySummaryHeartRate(
                                    1.5f,
                                    listOf(
                                            HeartRateZone(
                                                    1.5f,
                                                    2.5f,
                                                    3.5f,
                                                    "dummyName",
                                                    4.5f
                                            )
                                    )
                            ),
                            """
                                {
                                    "restingheartrate":1.5,
                                    "heartratezones":[
                                        {
                                            "max":1.5,
                                            "min":2.5,
                                            "minutes":3.5,
                                            "name":"dummyName",
                                            "caloriesout":4.5
                                        }
                                    ]
                                }
                            """.trimIndent()
                    )
            )
}