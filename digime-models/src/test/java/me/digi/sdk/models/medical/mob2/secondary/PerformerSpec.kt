package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TCodeableConcept
import me.digi.sdk.models.objects.medical.mob2.secondary.TOrganization
import me.digi.sdk.models.objects.medical.mob2.secondary.TReference

class PerformerSpec : ModelTest<Performer>(Performer::class.java) {
    override val emptyTest: Performer? = Performer(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Performer?, String>> =
            listOf(
                    Pair(
                            Performer(
                                    TReference.obj,
                                    TOrganization.obj,
                                    TCodeableConcept.obj
                            ),
                            """
                                {
                                    "actor":${TReference.json},
                                    "onbehalfof":${TOrganization.json},
                                    "role":${TCodeableConcept.json}
                                }
                            """.trimIndent()
                    )
            )
}