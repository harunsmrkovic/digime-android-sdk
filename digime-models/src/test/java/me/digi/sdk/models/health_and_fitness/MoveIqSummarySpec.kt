/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class MoveIqSummarySpec : ModelTest<MoveIqSummary>(MoveIqSummary::class.java) {
    override val emptyTest: MoveIqSummary? = MoveIqSummary(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<MoveIqSummary?, String>> =
            listOf(
                    Pair(
                            MoveIqSummary(
                                    "dummyAccountEntityId",
                                    1,
                                    2,
                                    3,
                                    "dummyEntityId",
                                    "dummyId",
                                    "dummyType",
                                    "dummySubType"
                            ),
                            """
                                {
                                    "accountentityid":"dummyAccountEntityId",
                                    "calendarDate":1,
                                    "createddate":2,
                                    "duration":3,
                                    "entityid":"dummyEntityId",
                                    "id":"dummyId",
                                    "type":"dummyType",
                                    "subType":"dummySubType"
                                }
                            """.trimIndent()
                    )
            )
}