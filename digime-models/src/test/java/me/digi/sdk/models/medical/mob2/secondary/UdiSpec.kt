package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class UdiSpec : ModelTest<Udi>(Udi::class.java, object : ModelParam<Udi> {
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

    override val jsonTests: List<Pair<Udi?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})