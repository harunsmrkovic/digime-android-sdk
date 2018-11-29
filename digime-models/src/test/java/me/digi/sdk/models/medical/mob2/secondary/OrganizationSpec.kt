package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class OrganizationSpec : ModelTest<Organization>(Organization::class.java, object : ModelParam<Organization> {
    override val emptyTest: Organization? = Organization(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Organization?, String>> =
            listOf(
                    Pair(
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
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Organization?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})