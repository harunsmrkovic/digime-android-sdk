package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class DailyActivitySummarySpec : ModelTest<DailyActivitySummary>(DailyActivitySummary::class.java) {
    override val emptyTest: DailyActivitySummary? = DailyActivitySummary(
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
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DailyActivitySummary?, String>> =
            listOf(
                    Pair(
                            DailyActivitySummary(
                                    "dummyId",
                                    "dummyEntityId",
                                    "dummyAccountEntityId",
                                    1,
                                    2.5f,
                                    3.5f,
                                    4.5f,
                                    5.5f,
                                    6.5f,
                                    7.5f,
                                    8.5f,
                                    9.5f,
                                    10.5f,
                                    11.5f,
                                    12,
                                    13,
                                    14.5f,
                                    listOf(
                                            Distance(
                                                    "dummyActivity",
                                                    1.5f
                                            )
                                    ),
                                    Goals(
                                            1.5f,
                                            2.5f,
                                            3.5f,
                                            4,
                                            5
                                    ),
                                    listOf(
                                            HeartRateZone(
                                                    1.5f,
                                                    2.5f,
                                                    3.5f,
                                                    "dummyName",
                                                    4.5f
                                            )
                                    ),
                                    15,
                                    16.5f,
                                    17.5f,
                                    18.5f
                            ),
                            """
                                {
                                    "id":"dummyId",
                                    "entityid":"dummyEntityId",
                                    "accountentityid":"dummyAccountEntityId",
                                    "createddate":1,
                                    "activescore":2.5,
                                    "sedentaryminutes":3.5,
                                    "lightlyactiveminutes":4.5,
                                    "fairlyactiveminutes":5.5,
                                    "veryactiveminutes":6.5,
                                    "activitycalories":7.5,
                                    "caloriesbmr":8.5,
                                    "marginalcalories":9.5,
                                    "caloriesout":10.5,
                                    "elevation":11.5,
                                    "floors":12,
                                    "steps":13,
                                    "restingheartrate":14.5,
                                    "distances":[
                                        {
                                            "activity":"dummyActivity",
                                            "distance":1.5
                                        }
                                    ],
                                    "goals":{
                                        "activeminutes":1.5,
                                        "caloriesout":2.5,
                                        "distance":3.5,
                                        "floors":4,
                                        "steps":5
                                    },
                                    "heartratezones":[
                                        {
                                            "max":1.5,
                                            "min":2.5,
                                            "minutes":3.5,
                                            "name":"dummyName",
                                            "caloriesout":4.5
                                        }
                                    ],
                                    "duration":15,
                                    "heartrate":16.5,
                                    "maxheartrate":17.5,
                                    "minheartrate":18.5
                                }
                            """.trimIndent()
                    )
            )
}