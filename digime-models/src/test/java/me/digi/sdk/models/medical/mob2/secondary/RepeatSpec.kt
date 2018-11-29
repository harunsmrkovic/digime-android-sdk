package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class RepeatSpec : ModelTest<Repeat>(Repeat::class.java) {
    override val emptyTest: Repeat? = Repeat(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Repeat?, String>> =
            listOf(
                    Pair(
                            Repeat(
                                    1,
                                    2,
                                    "dummyPeriodUnit",
                                    Period(1, 2)
                            ),
                            """
                                {
                                    "frequency":1,
                                    "period":2,
                                    "periodunit":"dummyPeriodUnit",
                                    "boundsperiod":{"start":1, "end":2}
                                }
                            """.trimIndent()
                    )
            )
}