package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.medical.mob2.primary.Device
import me.digi.sdk.models.medical.mob2.primary.Patient

class ParticipantSpec : ModelTest<Participant>(Participant::class.java) {
    override val emptyTest: Participant? = Participant(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Participant?, String>> =
            listOf(
                    Pair(
                            Participant(
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
                                    Reference(
                                            "dummyReference",
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
                                            "dummyDisplay",
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
                                            ),
                                            Patient(
                                                    "dummyentityid",
                                                    "dummyaccountentityid",
                                                    1,
                                                    2,
                                                    "dummyid",
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
                                                    listOf(
                                                            ContactPoint(
                                                                    "dummySystem",
                                                                    "dummyValue",
                                                                    "dummyUse",
                                                                    1,
                                                                    Period(1, 2)
                                                            )
                                                    ),
                                                    "dummygender",
                                                    3,
                                                    true,
                                                    4,
                                                    listOf(
                                                            Address(
                                                                    "dummyUse",
                                                                    "dummyType",
                                                                    "dummyText",
                                                                    listOf("dummyLine1", "dummyLine2"),
                                                                    "dummyCity",
                                                                    "dummyDistrict",
                                                                    "dummyState",
                                                                    "dummyPostalCode",
                                                                    "dummyCountry",
                                                                    Period(1, 2)
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
                                                    listOf(
                                                            Contact(
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
                                                                    ),
                                                                    HumanName(
                                                                            "dummyUse",
                                                                            "dummyText",
                                                                            "dummyFamily",
                                                                            listOf("dummyGiven1", "dummyGiven2"),
                                                                            listOf("dummyPrefix1", "dummyPrefix2"),
                                                                            listOf("dummySuffix1", "dummySuffix2"),
                                                                            Period(1, 2)
                                                                    ),
                                                                    listOf(
                                                                            ContactPoint(
                                                                                    "dummySystem",
                                                                                    "dummyValue",
                                                                                    "dummyUse",
                                                                                    1,
                                                                                    Period(1, 2)
                                                                            )
                                                                    ),
                                                                    Address(
                                                                            "dummyUse",
                                                                            "dummyType",
                                                                            "dummyText",
                                                                            listOf("dummyLine1", "dummyLine2"),
                                                                            "dummyCity",
                                                                            "dummyDistrict",
                                                                            "dummyState",
                                                                            "dummyPostalCode",
                                                                            "dummyCountry",
                                                                            Period(1, 2)
                                                                    ),
                                                                    "dummyGender",
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
                                                                    ),
                                                                    Period(1, 2)
                                                            )
                                                    ),
                                                    listOf(
                                                            Communication(
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
                                                                    true
                                                            )
                                                    )
                                            ),
                                            Device(
                                                    "dummyEntityId",
                                                    "dummyAccountEntityId",
                                                    1,
                                                    2,
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
                                                    Udi(
                                                            "dummyDeviceIdentifier",
                                                            "dummyName"
                                                    ),
                                                    "dummyModel",
                                                    3,
                                                    "dummyStatus",
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
                                    ),
                                    "dummyRequired",
                                    "dummyStatus"
                            ),
                            """
                                {
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
                                    "period":{"start":1, "end":2},
                                    "individual":{
                                        "reference":"dummyReference",
                                        "identifier":{
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
                                        },
                                        "display":"dummyDisplay",
                                        "practitioner":{
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
                                        },
                                        "organization":{
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
                                        },
                                        "patient":{
                                            "entityid":"dummyentityid",
                                            "accountentityid":"dummyaccountentityid",
                                            "createddate":1,
                                            "updateddate":2,
                                            "id":"dummyid",
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
                                            "telecom":[
                                                {
                                                    "system":"dummySystem",
                                                    "value":"dummyValue",
                                                    "use":"dummyUse",
                                                    "rank":1,
                                                    "period":{"start":1, "end":2}
                                                }
                                            ],
                                            "gender":"dummygender",
                                            "birthdate":3,
                                            "deceasedboolean":true,
                                            "deceaseddatetime":4,
                                            "address":[
                                                {
                                                    "use":"dummyUse",
                                                    "type":"dummyType",
                                                    "text":"dummyText",
                                                    "line":["dummyLine1","dummyLine2"],
                                                    "city":"dummyCity",
                                                    "district":"dummyDistrict",
                                                    "state":"dummyState",
                                                    "postalcode":"dummyPostalCode",
                                                    "country":"dummyCountry",
                                                    "period":{"start":1, "end":2}
                                                }
                                            ],
                                            "maritalstatus":{
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
                                            "contact":[
                                                {
                                                    "relationship":[
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
                                                    ],
                                                    "name":{
                                                        "use":"dummyUse",
                                                        "text":"dummyText",
                                                        "family":"dummyFamily",
                                                        "given":["dummyGiven1","dummyGiven2"],
                                                        "prefix":["dummyPrefix1","dummyPrefix2"],
                                                        "suffix":["dummySuffix1","dummySuffix2"],
                                                        "period":{"start":1, "end":2}
                                                    },
                                                    "telecom":[
                                                        {
                                                            "system":"dummySystem",
                                                            "value":"dummyValue",
                                                            "use":"dummyUse",
                                                            "rank":1,
                                                            "period":{"start":1, "end":2}
                                                        }
                                                    ],
                                                    "address":{
                                                        "use":"dummyUse",
                                                        "type":"dummyType",
                                                        "text":"dummyText",
                                                        "line":["dummyLine1","dummyLine2"],
                                                        "city":"dummyCity",
                                                        "district":"dummyDistrict",
                                                        "state":"dummyState",
                                                        "postalcode":"dummyPostalCode",
                                                        "country":"dummyCountry",
                                                        "period":{"start":1, "end":2}
                                                    },
                                                    "gender":"dummyGender",
                                                    "organization":{
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
                                                    },
                                                    "period":{"start":1, "end":2}
                                                }
                                            ],
                                            "communication":[
                                                {
                                                    "language":{
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
                                                    "preferred":true
                                                }
                                            ]
                                        },
                                        "device":{
                                            "entityid":"dummyEntityId",
                                            "accountentityid":"dummyAccountEntityId",
                                            "createddate":1,
                                            "updateddate":2,
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
                                            "udi":{
                                                "deviceidentifier":"dummyDeviceIdentifier",
                                                "name":"dummyName"
                                            },
                                            "model":"dummyModel",
                                            "expirationdate":3,
                                            "status":"dummyStatus",
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
                                            }
                                        }
                                    },
                                    "required":"dummyRequired",
                                    "status":"dummyStatus"
                                }
                            """.trimIndent()
                    )
            )
}