package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class RangeSpec : ModelTest<Range>(Range::class.java) {
    override val emptyTest: Range? = Range(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Range?, String>> =
            listOf(
                    Pair(
                            Range(
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
                                    "low":{
                                        "value":1,
                                        "unit":"dummyUnit",
                                        "system":"dummySystem",
                                        "code":"dummyCode"
                                    },
                                    "high":{
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