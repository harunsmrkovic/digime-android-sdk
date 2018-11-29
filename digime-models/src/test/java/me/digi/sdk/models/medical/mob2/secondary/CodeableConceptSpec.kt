package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class CodeableConceptSpec : ModelTest<CodeableConcept>(CodeableConcept::class.java, object : ModelParam<CodeableConcept> {
    override val emptyTest: CodeableConcept? = CodeableConcept(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<CodeableConcept?, String>> =
            listOf(
                    Pair(
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
                            """
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
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<CodeableConcept?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})