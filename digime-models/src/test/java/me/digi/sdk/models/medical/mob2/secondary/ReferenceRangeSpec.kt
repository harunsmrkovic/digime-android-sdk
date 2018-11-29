package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TCodeableConcept
import me.digi.sdk.models.objects.medical.mob2.secondary.TQuantity
import me.digi.sdk.models.objects.medical.mob2.secondary.TRange

class ReferenceRangeSpec : ModelTest<ReferenceRange>(ReferenceRange::class.java) {
    override val emptyTest: ReferenceRange? = ReferenceRange(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<ReferenceRange?, String>> =
            listOf(
                    Pair(
                            ReferenceRange(
                                    TQuantity.obj,
                                    TQuantity.obj,
                                    TCodeableConcept.obj,
                                    listOf(
                                            TCodeableConcept.obj
                                    ),
                                    TRange.obj,
                                    "dummyText"
                            ),
                            """
                                {
                                    "low":${TQuantity.json},
                                    "high":${TQuantity.json},
                                    "type":${TCodeableConcept.json},
                                    "appliesto":[
                                        ${TCodeableConcept.json}
                                    ],
                                    "age":${TRange.json},
                                    "text":"dummyText"
                                }
                            """.trimIndent()
                    )
            )
}