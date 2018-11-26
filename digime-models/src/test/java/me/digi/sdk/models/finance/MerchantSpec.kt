package me.digi.sdk.models.finance

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class MerchantSpec : ModelTest<Merchant>(Merchant::class.java, object : ModelParam<Merchant> {
    override val emptyTest: Merchant? = Merchant(null, null)

    override val jsonObjectTests: List<Pair<Merchant?, String>> =
            listOf(
                    Pair(
                            Merchant("dummyId", "dummyName"),
                            """{"id": "dummyId", "name": "dummyName"}"""
                    ),
                    Pair(
                            Merchant("dummyId", null),
                            """{"id": "dummyId"}"""
                    ),
                    Pair(
                            Merchant(null, "dummyName"),
                            """{"name": "dummyName"}"""
                    )
            )

    override val jsonTests: List<Pair<Merchant?, String>> =
            listOf(
                    Pair(
                            Merchant(null, null),
                            """{"type": "dummy"}"""
                    )
            )
})