/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.health_and_fitness.TSleepPhase
import me.digi.sdk.models.objects.health_and_fitness.TSleepSummary

class DaySummarySleepSpec : ModelTest<DaySummarySleep>(DaySummarySleep::class.java) {
    override val emptyTest: DaySummarySleep? = DaySummarySleep(
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
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummarySleep?, String>> =
            listOf(
                    Pair(
                            DaySummarySleep(
                                    "dummyId",
                                    "dummyEntityId",
                                    "dummyAccountEntityId",
                                    SleepDataType.CLASSIC,
                                    1,
                                    2,
                                    3,
                                    4,
                                    5,
                                    6,
                                    true,
                                    listOf(
                                            TSleepPhase.obj
                                    ),
                                    TSleepSummary.obj,
                                    7,
                                    8,
                                    9,
                                    10,
                                    11,
                                    12,
                                    13,
                                    14
                            ),
                            """
                                {
                                    "id":"dummyId",
                                    "entityid":"dummyEntityId",
                                    "accountentityid":"dummyAccountEntityId",
                                    "type":"classic",
                                    "createddate":1,
                                    "startdate":2,
                                    "enddate":3,
                                    "efficiency":4,
                                    "duration":5,
                                    "infocode":6,
                                    "ismainsleep":true,
                                    "levels":[
                                        ${TSleepPhase.json}
                                    ],
                                    "summary":${TSleepSummary.json},
                                    "minutesafterwakeup":7,
                                    "minutesasleep":8,
                                    "minutesawake":9,
                                    "minutestofallasleep":10,
                                    "timeinbed":11,
                                    "awakeduration":12,
                                    "deepsleepduration":13,
                                    "lightsleepduration":14
                                }
                            """.trimIndent()
                    )
            )
}