package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class DaySummaryFloorsClimbedSpec : ModelTest<DaySummaryFloorsClimbed>(DaySummaryFloorsClimbed::class.java, object : ModelParam<DaySummaryFloorsClimbed> {
    override val emptyTest: DaySummaryFloorsClimbed? = DaySummaryFloorsClimbed(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummaryFloorsClimbed?, String>> =
            listOf(
                    Pair(
                            DaySummaryFloorsClimbed(
                                    1,
                                    2
                            ),
                            """
                                {
                                    "floors":1,
                                    "goal":2
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<DaySummaryFloorsClimbed?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})