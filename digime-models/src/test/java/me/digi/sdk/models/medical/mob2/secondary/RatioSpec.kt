package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TQuantity

class RatioSpec : ModelTest<Ratio>(Ratio::class.java) {
    override val emptyTest: Ratio? = Ratio(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Ratio?, String>> =
            listOf(
                    Pair(
                            Ratio(
                                    TQuantity.obj,
                                    TQuantity.obj
                            ),
                            """
                                {
                                    "numerator":${TQuantity.json},
                                    "denominator":${TQuantity.json}
                                }
                            """.trimIndent()
                    )
            )
}