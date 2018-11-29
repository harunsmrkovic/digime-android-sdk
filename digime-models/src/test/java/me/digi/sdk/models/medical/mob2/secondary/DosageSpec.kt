package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class DosageSpec : ModelTest<Dosage>(Dosage::class.java) {
    override val emptyTest: Dosage? = Dosage(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Dosage?, String>> =
            listOf(
                    Pair(
                            Dosage(
                                    1,
                                    "dummyText",
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
                                    true,
                                    CodeableConcept(
                                            listOf(
                                                    Coding(
                                                            "dummyCode",
                                                            "dummyDisplay",
                                                            "dummySystem",
                                                            "dummyVersion"
                                                    )
                                            ),
                                            "dummyText1"
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
                                            "dummyText2"
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
                                            "dummyText3"
                                    ),
                                    Quantity(
                                            1,
                                            "dummyUnit",
                                            "dummySystem",
                                            "dummyCode"
                                    )
                            ),
                            """
                                {
                                    "sequence":1,
                                    "text":"dummyText",
                                    "timing":{
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
                                    },
                                    "asneededboolean":true,
                                    "site":{
                                        "coding":[
                                            {
                                                "code": "dummyCode",
                                                "display": "dummyDisplay",
                                                "system": "dummySystem",
                                                "version": "dummyVersion"
                                            }
                                        ],
                                        "text":"dummyText1"
                                    },
                                    "route":{
                                        "coding":[
                                            {
                                                "code": "dummyCode",
                                                "display": "dummyDisplay",
                                                "system": "dummySystem",
                                                "version": "dummyVersion"
                                            }
                                        ],
                                        "text":"dummyText2"
                                    },
                                    "method":{
                                        "coding":[
                                            {
                                                "code": "dummyCode",
                                                "display": "dummyDisplay",
                                                "system": "dummySystem",
                                                "version": "dummyVersion"
                                            }
                                        ],
                                        "text":"dummyText3"
                                    },
                                    "dosequantity":{
                                        "value":1,
                                        "unit":"dummyUnit",
                                        "system":"dummySystem",
                                        "code":"dummyCode"
                                    }
                                }
                            """.trimIndent()
                    )
            )
}