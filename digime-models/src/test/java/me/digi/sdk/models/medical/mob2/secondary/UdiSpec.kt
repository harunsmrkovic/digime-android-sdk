package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class UdiSpec : ModelTest<Udi>(Udi::class.java) {
    override val emptyTest: Udi? = Udi(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Udi?, String>> =
            listOf(
                    Pair(
                            Udi(
                                    "dummyDeviceIdentifier",
                                    "dummyName"
                            ),
                            """
                                {
                                    "deviceidentifier":"dummyDeviceIdentifier",
                                    "name":"dummyName"
                                }
                            """.trimIndent()
                    )
            )
}