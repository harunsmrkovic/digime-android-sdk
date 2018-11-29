package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class QualificationSpec : ModelTest<Qualification>(Qualification::class.java) {
    override val emptyTest: Qualification? = Qualification(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Qualification?, String>> =
            listOf(
                    Pair(
                            Qualification(
                                    listOf(
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
                                            )
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
                                    ),
                                    Period(1, 2),
                                    Organization(
                                            "dummyId",
                                            listOf(
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
                                                    )
                                            ),
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
                                    "identifier":[
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
                                    ],
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
                                    },
                                    "period":{"start":1, "end":2},
                                    "issuer":{
                                        "id":"dummyId",
                                        "identifier":[
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
                                        ],
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