package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class GoalsSpec : ModelTest<Goals>(Goals::class.java, object : ModelParam<Goals> {
    override val emptyTest: Goals? = Goals(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Goals?, String>> =
            listOf(
                    Pair(
                            Goals(
                                    1.5f,
                                    2.5f,
                                    3.5f,
                                    4,
                                    5
                            ),
                            """
                                {
                                    "activeminutes":1.5,
                                    "caloriesout":2.5,
                                    "distance":3.5,
                                    "floors":4,
                                    "steps":5
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Goals?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})

class DistanceSpec : ModelTest<Distance>(Distance::class.java, object : ModelParam<Distance> {
    override val emptyTest: Distance? = Distance(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Distance?, String>> =
            listOf(
                    Pair(
                            Distance(
                                    "dummyActivity",
                                    1.5f
                            ),
                            """
                                {
                                    "activity":"dummyActivity",
                                    "distance":1.5
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Distance?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})

class SleepPhaseSpec : ModelTest<SleepPhase>(SleepPhase::class.java, object : ModelParam<SleepPhase> {
    override val emptyTest: SleepPhase? = SleepPhase(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SleepPhase?, String>> =
            listOf(
                    Pair(
                            SleepPhase(
                                    1,
                                    "dummyLevel",
                                    2
                            ),
                            """
                                {
                                    "createddate":1,
                                    "level":"dummyLevel",
                                    "seconds":2
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<SleepPhase?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})

class SleepSummarySpec : ModelTest<SleepSummary>(SleepSummary::class.java, object : ModelParam<SleepSummary> {
    override val emptyTest: SleepSummary? = SleepSummary(
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SleepSummary?, String>> =
            listOf(
                    Pair(
                            SleepSummary(
                                    SleepPhaseSummary(1, 2, 3),
                                    SleepPhaseSummary(4, 5, 6),
                                    SleepPhaseSummary(7, 8, 9),
                                    SleepPhaseSummary(10, 11, 12),
                                    SleepPhaseSummary(13, 14, 15),
                                    SleepPhaseSummary(16, 17, 18),
                                    SleepPhaseSummary(19, 20, 21)
                            ),
                            """
                                {
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
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<SleepSummary?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})

class SleepPhaseSummarySpec : ModelTest<SleepPhaseSummary>(SleepPhaseSummary::class.java, object : ModelParam<SleepPhaseSummary> {
    override val emptyTest: SleepPhaseSummary? = SleepPhaseSummary(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SleepPhaseSummary?, String>> =
            listOf(
                    Pair(
                            SleepPhaseSummary(
                                    1,
                                    2,
                                    3
                            ),
                            """
                                {
                                    "count":1,
                                    "minutes":2,
                                    "thirtydayavgminutes":3
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<SleepPhaseSummary?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})

data class SleepDataTypeDummy(val type: SleepDataType)

class SleepDataTypeSpec : ModelTest<SleepDataTypeDummy>(SleepDataTypeDummy::class.java, object : ModelParam<SleepDataTypeDummy> {
    override val jsonTests: List<Pair<SleepDataTypeDummy?, String>> = emptyList()

    override val emptyTest: SleepDataTypeDummy? = null

    override val jsonObjectTests: List<Pair<SleepDataTypeDummy?, String>> =
            listOf(
                    Pair(
                            SleepDataTypeDummy(SleepDataType.STAGES),
                            """{"type":"stages"}""".trimIndent()
                    ),
                    Pair(
                            SleepDataTypeDummy(SleepDataType.CLASSIC),
                            """{"type":"classic"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"type":"wrong"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"type":1}""".trimIndent()
                    )
            )
})

