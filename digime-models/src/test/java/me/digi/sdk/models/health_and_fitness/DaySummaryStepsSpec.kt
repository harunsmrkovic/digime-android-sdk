package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class DaySummaryStepsSpec : ModelTest<DaySummarySteps>(DaySummarySteps::class.java, object : ModelParam<DaySummarySteps> {
    override val emptyTest: DaySummarySteps? = DaySummarySteps(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummarySteps?, String>> =
            listOf(
                    Pair(
                            DaySummarySteps(
                                    1,
                                    2
                            ),
                            """
                                {
                                    "steps":1,
                                    "goal":2
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<DaySummarySteps?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})