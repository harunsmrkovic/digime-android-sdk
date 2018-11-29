package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class EpochSummarySpec : ModelTest<EpochSummary>(EpochSummary::class.java) {
    override val emptyTest: EpochSummary? = EpochSummary(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<EpochSummary?, String>> =
            listOf(
                    Pair(
                            EpochSummary(
                                    "dummyAccountEntityId",
                                    1,
                                    2,
                                    3,
                                    "dummyEntityId",
                                    "dummyId",
                                    "dummyIntensity",
                                    4,
                                    5,
                                    6,
                                    7,
                                    8,
                                    9,
                                    "dummyType"
                            ),
                            """
                                {
                                    "accountentityid":"dummyAccountEntityId",
                                    "createddate":1,
                                    "distance":2,
                                    "duration":3,
                                    "entityid":"dummyEntityId",
                                    "id":"dummyId",
                                    "intensity":"dummyIntensity",
                                    "kilocalories":4,
                                    "maxmotionintensity":5,
                                    "meanmotionintensity":6,
                                    "met":7,
                                    "steps":8,
                                    "time":9,
                                    "type":"dummyType"
                                }
                            """.trimIndent()
                    )
            )
}