package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.medical.mob2.primary.Medication

class MedicationPackageSpec : ModelTest<MedicationPackage>(MedicationPackage::class.java) {
    override val emptyTest: MedicationPackage? = MedicationPackage(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<MedicationPackage?, String>> =
            listOf(
                    Pair(
                            MedicationPackage(
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
                                            MedicationPackageContent(
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
                                                    Medication(
                                                            "dummyEntityId",
                                                            "dummyAccountEntityId",
                                                            1,
                                                            2,
                                                            "dummyId",
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
                                                                    "dummyText2"
                                                            ),
                                                            MedicationPackage(
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
                                                                            MedicationPackageContent(
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
                                                                                    Medication(
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null,
                                                                                            null
                                                                                    ),
                                                                                    Quantity(
                                                                                            1,
                                                                                            "dummyUnit",
                                                                                            "dummySystem",
                                                                                            "dummyCode"
                                                                                    )
                                                                            )
                                                                    )
                                                            )
                                                    ),
                                                    Quantity(
                                                            1,
                                                            "dummyUnit",
                                                            "dummySystem",
                                                            "dummyCode"
                                                    )
                                            )
                                    )
                            ),
                            """
                                {
                                    "container":{
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
                                    "content":[
                                        {
                                            "itemcodeableconcept":{
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
                                            "itemReference":{
                                                "entityid":"dummyEntityId",
                                                "accountentityid":"dummyAccountEntityId",
                                                "createddate":1,
                                                "updateddate":2,
                                                "id":"dummyId",
                                                "code":{
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
                                                "status":"dummyStatus",
                                                "form":{
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
                                                "package":{
                                                    "container":{
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
                                                    "content":[
                                                        {
                                                            "itemcodeableconcept":{
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
                                                            "itemReference":{},
                                                            "amount":{
                                                                "value":1,
                                                                "unit":"dummyUnit",
                                                                "system":"dummySystem",
                                                                "code":"dummyCode"
                                                            }
                                                        }
                                                    ]
                                                }
                                            },
                                            "amount":{
                                                "value":1,
                                                "unit":"dummyUnit",
                                                "system":"dummySystem",
                                                "code":"dummyCode"
                                            }
                                        }
                                    ]
                                }
                            """.trimIndent()
                    )
            )
}