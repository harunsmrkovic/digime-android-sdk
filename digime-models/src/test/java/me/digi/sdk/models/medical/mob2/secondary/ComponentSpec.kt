package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class ComponentSpec : ModelTest<Component>(Component::class.java, object : ModelParam<Component> {
    override val emptyTest: Component? = Component(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Component?, String>> =
            listOf(
                    Pair(
                            Component(
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
                                    Quantity(
                                            1,
                                            "dummyUnit",
                                            "dummySystem",
                                            "dummyCode"
                                    )
                            ),
                            """
                                {
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
                                    "valuequantity":{
                                        "value":1,
                                        "unit":"dummyUnit",
                                        "system":"dummySystem",
                                        "code":"dummyCode"
                                    }
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Component?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})