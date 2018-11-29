package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class IdentifierSpec : ModelTest<Identifier>(Identifier::class.java) {
    override val emptyTest: Identifier? = Identifier(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Identifier?, String>> =
            listOf(
                    Pair(
                            Identifier(
                                    "dummyUse",
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
                                    ),
                                    "dummySystem",
                                    "dummyValue",
                                    Period(1, 2),
                                    Organization(
                                            "dummyId",
                                            emptyList(),
                                            true,
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
                                                            "dummyText"
                                                    )
                                            )
                                    )
                            ),
                            """
                                {
                                    "use":"dummyUse",
                                    "type":{
                                        "coding":[
                                            {
                                                "code": "dummyCode",
                                                "display": "dummyDisplay",
                                                "system": "dummySystem",
                                                "version": "dummyVersion"
                                            }
                                        ],
                                        "text":"dummyText"
                                    },
                                    "system":"dummySystem",
                                    "value":"dummyValue",
                                    "period":{"start":1, "end":2},
                                    "assigner":{
                                        "id":"dummyId",
                                        "identifier":[],
                                        "active":true,
                                        "type":[
                                            {
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
                                        ]
                                    }
                                }
                            """.trimIndent()
                    )
            )
}