package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class ReferenceRangeSpec : ModelTest<ReferenceRange>(ReferenceRange::class.java) {
    override val emptyTest: ReferenceRange? = ReferenceRange(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<ReferenceRange?, String>> =
            listOf(
                    Pair(
                            ReferenceRange(
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
                                            "dummyText1"
                                    ),
                                    listOf(
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
                                            )
                                    ),
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
                                    "dummyText"
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
                                    },
                                    "type":{
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
                                    "appliesto":[
                                        {
                                            "coding":[
                                                {
                                                    "code": "dummyCode",
                                                    "display": "dummyDisplay",
                                                    "system": "dummySystem",
                                                    "version": "dummyVersion"
                                                }
                                            ],
                                            "text":"dummyText2"
                                        }
                                    ],
                                    "age":{
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
                                    },
                                    "text":"dummyText"
                                }
                            """.trimIndent()
                    )
            )
}