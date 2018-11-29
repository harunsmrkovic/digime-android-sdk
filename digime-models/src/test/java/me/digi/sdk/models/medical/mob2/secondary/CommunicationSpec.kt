package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class CommunicationSpec : ModelTest<Communication>(Communication::class.java, object : ModelParam<Communication> {
    override val emptyTest: Communication? = Communication(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Communication?, String>> =
            listOf(
                    Pair(
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
                            ),
                            """
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
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Communication?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})