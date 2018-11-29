package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class CodingSpec : ModelTest<Coding>(Coding::class.java, object : ModelParam<Coding> {
    override val emptyTest: Coding? = Coding(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Coding?, String>> =
            listOf(
                    Pair(
                            Coding(
                                    "dummyCode",
                                    "dummyDisplay",
                                    "dummySystem",
                                    "dummyVersion"
                            ),
                            """
                                {
                                    "code": "dummyCode",
                                    "display": "dummyDisplay",
                                    "system": "dummySystem",
                                    "version": "dummyVersion"
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Coding?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})