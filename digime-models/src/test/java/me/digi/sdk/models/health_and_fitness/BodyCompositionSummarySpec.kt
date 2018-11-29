/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class BodyCompositionSummarySpec : ModelTest<BodyCompositionSummary>(BodyCompositionSummary::class.java) {
    override val emptyTest: BodyCompositionSummary? = BodyCompositionSummary(
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

    override val jsonObjectTests: List<Pair<BodyCompositionSummary?, String>> =
            listOf(
                    Pair(
                            BodyCompositionSummary(
                                    "dummyAccountEntityId",
                                    1.5,
                                    2.5,
                                    3.5,
                                    4,
                                    5,
                                    "dummyEntityId",
                                    6,
                                    7
                            ),
                            """
                                {
                                    "accountentityid":"dummyAccountEntityId",
                                    "bodyWater":1.5,
                                    "bodyFat":2.5,
                                    "bodyMassIndex":3.5,
                                    "boneMass":4,
                                    "createddate":5,
                                    "entityid":"dummyEntityId",
                                    "muscleMass":6,
                                    "weight":7
                                }
                            """.trimIndent()
                    )
            )
}