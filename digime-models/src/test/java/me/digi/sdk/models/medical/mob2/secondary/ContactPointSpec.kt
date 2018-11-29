package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class ContactPointSpec : ModelTest<ContactPoint>(ContactPoint::class.java) {
    override val emptyTest: ContactPoint? = ContactPoint(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<ContactPoint?, String>> =
            listOf(
                    Pair(
                            ContactPoint(
                                    "dummySystem",
                                    "dummyValue",
                                    "dummyUse",
                                    1,
                                    Period(1, 2)
                            ),
                            """
                                {
                                    "system":"dummySystem",
                                    "value":"dummyValue",
                                    "use":"dummyUse",
                                    "rank":1,
                                    "period":{"start":1, "end":2}
                                }
                            """.trimIndent()
                    )
            )
}