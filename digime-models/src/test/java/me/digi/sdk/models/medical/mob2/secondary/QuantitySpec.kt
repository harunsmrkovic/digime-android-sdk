package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class QuantitySpec : ModelTest<Quantity>(Quantity::class.java, object : ModelParam<Quantity> {
    override val emptyTest: Quantity? = Quantity(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Quantity?, String>> =
            listOf(
                    Pair(
                            Quantity(
                                    1,
                                    "dummyUnit",
                                    "dummySystem",
                                    "dummyCode"
                            ),
                            """
                                {
                                    "value":1,
                                    "unit":"dummyUnit",
                                    "system":"dummySystem",
                                    "code":"dummyCode"
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Quantity?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})