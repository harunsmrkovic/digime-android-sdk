package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class PractitionerSpec : ModelTest<Practitioner>(Practitioner::class.java) {
    override val emptyTest: Practitioner? = Practitioner(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Practitioner?, String>> =
            listOf(
                    Pair(
                            Practitioner(
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
                                            HumanName(
                                                    "dummyUse",
                                                    "dummyText",
                                                    "dummyFamily",
                                                    listOf("dummyGiven1", "dummyGiven2"),
                                                    listOf("dummyPrefix1", "dummyPrefix2"),
                                                    listOf("dummySuffix1", "dummySuffix2"),
                                                    Period(1, 2)
                                            )
                                    ),
                                    "dummyGender",
                                    listOf(
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
                                            )
                                    )
                            ),
                            """
                                {
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
                                    "name":[
                                        {
                                            "use":"dummyUse",
                                            "text":"dummyText",
                                            "family":"dummyFamily",
                                            "given":["dummyGiven1","dummyGiven2"],
                                            "prefix":["dummyPrefix1","dummyPrefix2"],
                                            "suffix":["dummySuffix1","dummySuffix2"],
                                            "period":{"start":1, "end":2}
                                        }
                                    ],
                                    "gender":"dummyGender",
                                    "qualification":[
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
                                    ]
                                }
                            """.trimIndent()
                    )
            )
}