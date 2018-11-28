package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class DaySummaryCaloriesSpec : ModelTest<DaySummaryCalories>(DaySummaryCalories::class.java, object : ModelParam<DaySummaryCalories> {
    override val emptyTest: DaySummaryCalories? = DaySummaryCalories(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummaryCalories?, String>> =
            listOf(
                    Pair(
                            DaySummaryCalories(
                                    1.5f,
                                    2.5f,
                                    3.5f,
                                    4.5f,
                                    5.5f
                            ),
                            """
                                {
                                    "activityCalories":1.5,
                                    "caloriesBmr":2.5,
                                    "marginalCalories":3.5,
                                    "caloriesOut":4.5,
                                    "goal":5.5
                                }
                            """.trimIndent()
                    ),
                    Pair(
                            DaySummaryCalories(
                                    1f,
                                    2f,
                                    3f,
                                    4f,
                                    5f
                            ),
                            """
                                {
                                    "activityCalories":1,
                                    "caloriesBmr":2,
                                    "marginalCalories":3,
                                    "caloriesOut":4,
                                    "goal":5
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<DaySummaryCalories?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})