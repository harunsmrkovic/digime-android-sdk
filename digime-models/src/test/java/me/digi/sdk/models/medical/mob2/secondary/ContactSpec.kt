package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class ContactSpec : ModelTest<Contact>(Contact::class.java, object : ModelParam<Contact> {
    override val emptyTest: Contact? = Contact(
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Contact?, String>> =
            listOf(
                    Pair(
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
                            ),
                            """
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
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Contact?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})