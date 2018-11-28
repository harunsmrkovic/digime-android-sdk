package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class DaySummarySleepSpec : ModelTest<DaySummarySleep>(DaySummarySleep::class.java, object : ModelParam<DaySummarySleep> {
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
                                            SleepPhase(
                                                    1,
                                                    "dummyLevel",
                                                    2
                                            )
                                    ),
                                    SleepSummary(
                                            SleepPhaseSummary(1, 2, 3),
                                            SleepPhaseSummary(4, 5, 6),
                                            SleepPhaseSummary(7, 8, 9),
                                            SleepPhaseSummary(10, 11, 12),
                                            SleepPhaseSummary(13, 14, 15),
                                            SleepPhaseSummary(16, 17, 18),
                                            SleepPhaseSummary(19, 20, 21)
                                    ),
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
                                        {
                                            "createddate":1,
                                            "level":"dummyLevel",
                                            "seconds":2
                                        }
                                    ],
                                    "summary":{
                                        "asleep":{
                                            "count":1,
                                            "minutes":2,
                                            "thirtydayavgminutes":3
                                        },
                                        "restless":{
                                            "count":4,
                                            "minutes":5,
                                            "thirtydayavgminutes":6
                                        },
                                        "awake":{
                                            "count":7,
                                            "minutes":8,
                                            "thirtydayavgminutes":9
                                        },
                                        "deep":{
                                            "count":10,
                                            "minutes":11,
                                            "thirtydayavgminutes":12
                                        },
                                        "light":{
                                            "count":13,
                                            "minutes":14,
                                            "thirtydayavgminutes":15
                                        },
                                        "rem":{
                                            "count":16,
                                            "minutes":17,
                                            "thirtydayavgminutes":18
                                        },
                                        "wake":{
                                            "count":19,
                                            "minutes":20,
                                            "thirtydayavgminutes":21
                                        }
                                    },
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

    override val jsonTests: List<Pair<DaySummarySleep?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})