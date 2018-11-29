package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class DispenseRequestSpec : ModelTest<DispenseRequest>(DispenseRequest::class.java, object : ModelParam<DispenseRequest> {
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
                                    Period(1, 2),
                                    1,
                                    Quantity(
                                            1,
                                            "dummyUnit",
                                            "dummySystem",
                                            "dummyCode"
                                    ),
                                    Quantity(
                                            2,
                                            "dummyUnit",
                                            "dummySystem",
                                            "dummyCode"
                                    )
                            ),
                            """
                                {
                                    "validityperiod":{"start":1, "end":2},
                                    "numberofrepeatsallowed":1,
                                    "quantity":{
                                        "value":1,
                                        "unit":"dummyUnit",
                                        "system":"dummySystem",
                                        "code":"dummyCode"
                                    },
                                    "expectedsupplyduration":{
                                        "value":2,
                                        "unit":"dummyUnit",
                                        "system":"dummySystem",
                                        "code":"dummyCode"
                                    }
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<DispenseRequest?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})