package me.digi.sdk.models.medical.mob2.primary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.medical.mob2.secondary.*

class DeviceSpec : ModelTest<Device>(Device::class.java, object : ModelParam<Device> {
    override val emptyTest: Device? = Device(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Device?, String>> =
            listOf(
                    Pair(
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
                            ),
                            """
                                {
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
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Device?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})