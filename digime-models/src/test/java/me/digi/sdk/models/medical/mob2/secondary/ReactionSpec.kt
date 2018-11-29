package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TAnnotation
import me.digi.sdk.models.objects.medical.mob2.secondary.TCodeableConcept

class ReactionSpec : ModelTest<Reaction>(Reaction::class.java) {
    override val emptyTest: Reaction? = Reaction(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Reaction?, String>> =
            listOf(
                    Pair(
                            Reaction(
                                    TCodeableConcept.obj,
                                    1,
                                    listOf(
                                            TCodeableConcept.obj
                                    ),
                                    listOf(
                                            TAnnotation.obj
                                    )
                            ),
                            """
                                {
                                    "substance":${TCodeableConcept.json},
                                    "onset":1,
                                    "manifestation":[
                                        ${TCodeableConcept.json}
                                    ],
                                    "note":[
                                        ${TAnnotation.json}
                                    ]
                                }
                            """.trimIndent()
                    )
            )
}