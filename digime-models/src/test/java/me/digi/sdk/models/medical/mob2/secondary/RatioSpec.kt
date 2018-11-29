package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class RatioSpec : ModelTest<Ratio>(Ratio::class.java) {
    override val emptyTest: Ratio? = Ratio(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Ratio?, String>> =
            listOf(
                    Pair(
                            Ratio(
                                    Quantity(
                                            1,
                                            "dummyUnit",
                                            "dummySystem",
                                            "dummyCode"
                                    ),
                                    Quantity(
                                            2,
                                            "dummyUnit",
                                            "dummySystem",
                                            "dummyCode"
                                    )
                            ),
                            """
                                {
                                    "numerator":{
                                        "value":1,
                                        "unit":"dummyUnit",
                                        "system":"dummySystem",
                                        "code":"dummyCode"
                                    },
                                    "denominator":{
                                        "value":2,
                                        "unit":"dummyUnit",
                                        "system":"dummySystem",
                                        "code":"dummyCode"
                                    }
                                }
                            """.trimIndent()
                    )
            )
}