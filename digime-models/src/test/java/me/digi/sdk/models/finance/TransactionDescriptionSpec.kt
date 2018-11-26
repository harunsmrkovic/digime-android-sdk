package me.digi.sdk.models.finance

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class TransactionDescriptionSpec : ModelTest<TransactionDescription>(TransactionDescription::class.java, object : ModelParam<TransactionDescription> {
    override val emptyTest: TransactionDescription? = TransactionDescription(null, null)

    override val jsonObjectTests: List<Pair<TransactionDescription?, String>> =
            listOf(
                    Pair(
                            TransactionDescription("dummyOriginal", "dummySimple"),
                            """{"original": "dummyOriginal", "simple": "dummySimple"}"""
                    ),
                    Pair(
                            TransactionDescription("dummyOriginal", null),
                            """{"original": "dummyOriginal"}"""
                    ),
                    Pair(
                            TransactionDescription(null, "dummySimple"),
                            """{"simple": "dummySimple"}"""
                    )
            )

    override val jsonTests: List<Pair<TransactionDescription?, String>> =
            listOf(
                    Pair(
                            TransactionDescription(null, null),
                            """{"type": "dummy"}"""
                    )
            )
})