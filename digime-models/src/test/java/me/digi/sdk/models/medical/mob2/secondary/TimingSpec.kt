package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class TimingSpec : ModelTest<Timing>(Timing::class.java) {
    override val emptyTest: Timing? = Timing(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Timing?, String>> =
            listOf(
                    Pair(
                            Timing(
                                    Repeat(
                                            1,
                                            2,
                                            "dummyPeriodUnit",
                                            Period(1, 2)
                                    ),
                                    CodeableConcept(
                                            listOf(
                                                    Coding(
                                                            "dummyCode",
                                                            "dummyDisplay",
                                                            "dummySystem",
                                                            "dummyVersion"
                                                    )
                                            ),
                                            "dummyText"
                                    )
                            ),
                            """
                                {
                                    "repeat":{
                                        "frequency":1,
                                        "period":2,
                                        "periodunit":"dummyPeriodUnit",
                                        "boundsperiod":{"start":1, "end":2}
                                    },
                                    "code":{
                                        "coding":[
                                            {
                                                "code": "dummyCode",
                                                "display": "dummyDisplay",
                                                "system": "dummySystem",
                                                "version": "dummyVersion"
                                            }
                                        ],
                                        "text":"dummyText"
                                    }
                                }
                            """.trimIndent()
                    )
            )
}