package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TCodeableConcept
import me.digi.sdk.models.objects.medical.mob2.secondary.TQuantity
import me.digi.sdk.models.objects.medical.mob2.secondary.TTiming

class DosageSpec : ModelTest<Dosage>(Dosage::class.java) {
    override val emptyTest: Dosage? = Dosage(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Dosage?, String>> =
            listOf(
                    Pair(
                            Dosage(
                                    1,
                                    "dummyText",
                                    TTiming.obj,
                                    true,
                                    TCodeableConcept.obj,
                                    TCodeableConcept.obj,
                                    TCodeableConcept.obj,
                                    TQuantity.obj
                            ),
                            """
                                {
                                    "sequence":1,
                                    "text":"dummyText",
                                    "timing":${TTiming.json},
                                    "asneededboolean":true,
                                    "site":${TCodeableConcept.json},
                                    "route":${TCodeableConcept.json},
                                    "method":${TCodeableConcept.json},
                                    "dosequantity":${TQuantity.json}
                                }
                            """.trimIndent()
                    )
            )
}