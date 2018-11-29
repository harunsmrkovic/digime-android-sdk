/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class StressSummarySpec : ModelTest<StressSummary>(StressSummary::class.java) {
    override val emptyTest: StressSummary? = StressSummary(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<StressSummary?, String>> =
            listOf(
                    Pair(
                            StressSummary(
                                    "dummyAccountEntityId",
                                    "dummyEntityId",
                                    "dummyId",
                                    1,
                                    2,
                                    3
                            ),
                            """
                                {
                                    "accountentityid":"dummyAccountEntityId",
                                    "entityid":"dummyEntityId",
                                    "id":"dummyId",
                                    "createddate":1,
                                    "duration":2,
                                    "calendarDate":3
                                }
                            """.trimIndent()
                    )
            )
}