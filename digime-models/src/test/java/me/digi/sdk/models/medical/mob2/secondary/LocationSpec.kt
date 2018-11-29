package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class LocationSpec : ModelTest<Location>(Location::class.java, object : ModelParam<Location> {
    override val emptyTest: Location? = Location(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Location?, String>> =
            listOf(
                    Pair(
                            Location(
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
                                    "dummyStatus",
                                    "dummyName",
                                    listOf("dummyAlias1", "dummyAlias2"),
                                    "dummyDescription",
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
                                    "status":"dummyStatus",
                                    "name":"dummyName",
                                    "alias":["dummyAlias1","dummyAlias2"],
                                    "description":"dummyDescription",
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
                                    "physicaltype":{
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

    override val jsonTests: List<Pair<Location?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})