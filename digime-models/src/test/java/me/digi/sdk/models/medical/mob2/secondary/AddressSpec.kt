package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class AddressSpec : ModelTest<Address>(Address::class.java) {
    override val emptyTest: Address? = Address(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Address?, String>> =
            listOf(
                    Pair(
                            Address(
                                    "dummyUse",
                                    "dummyType",
                                    "dummyText",
                                    listOf("dummyLine1", "dummyLine2"),
                                    "dummyCity",
                                    "dummyDistrict",
                                    "dummyState",
                                    "dummyPostalCode",
                                    "dummyCountry",
                                    Period(1, 2)
                            ),
                            """
                                {
                                    "use":"dummyUse",
                                    "type":"dummyType",
                                    "text":"dummyText",
                                    "line":["dummyLine1","dummyLine2"],
                                    "city":"dummyCity",
                                    "district":"dummyDistrict",
                                    "state":"dummyState",
                                    "postalcode":"dummyPostalCode",
                                    "country":"dummyCountry",
                                    "period":{"start":1, "end":2}
                                }
                            """.trimIndent()
                    )
            )
}