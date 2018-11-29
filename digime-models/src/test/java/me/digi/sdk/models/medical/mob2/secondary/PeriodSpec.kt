package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class PeriodSpec : ModelTest<Period>(Period::class.java) {
    override val emptyTest: Period? = Period(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Period?, String>> =
            listOf(
                    Pair(
                            Period(
                                    1,
                                    2
                            ),
                            """
                                {
                                    "start":1,
                                    "end":2
                                }
                            """.trimIndent()
                    )
            )
}