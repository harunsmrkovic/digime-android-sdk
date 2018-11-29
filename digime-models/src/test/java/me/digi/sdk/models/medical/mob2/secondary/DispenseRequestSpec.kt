package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TPeriod
import me.digi.sdk.models.objects.medical.mob2.secondary.TQuantity

class DispenseRequestSpec : ModelTest<DispenseRequest>(DispenseRequest::class.java) {
    override val emptyTest: DispenseRequest? = DispenseRequest(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DispenseRequest?, String>> =
            listOf(
                    Pair(
                            DispenseRequest(
                                    TPeriod.obj,
                                    1,
                                    TQuantity.obj,
                                    TQuantity.obj
                            ),
                            """
                                {
                                    "validityperiod":${TPeriod.json},
                                    "numberofrepeatsallowed":1,
                                    "quantity":${TQuantity.json},
                                    "expectedsupplyduration":${TQuantity.json}
                                }
                            """.trimIndent()
                    )
            )
}