package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TCodeableConcept
import me.digi.sdk.models.objects.medical.mob2.secondary.TQuantity

class ComponentSpec : ModelTest<Component>(Component::class.java) {
    override val emptyTest: Component? = Component(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Component?, String>> =
            listOf(
                    Pair(
                            Component(
                                    TCodeableConcept.obj,
                                    TQuantity.obj
                            ),
                            """
                                {
                                    "code":${TCodeableConcept.json},
                                    "valuequantity":${TQuantity.json}
                                }
                            """.trimIndent()
                    )
            )
}