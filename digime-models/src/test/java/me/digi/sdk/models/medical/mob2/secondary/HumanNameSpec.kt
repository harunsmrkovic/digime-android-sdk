package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest

class HumanNameSpec : ModelTest<HumanName>(HumanName::class.java) {
    override val emptyTest: HumanName? = HumanName(
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<HumanName?, String>> =
            listOf(
                    Pair(
                            HumanName(
                                    "dummyUse",
                                    "dummyText",
                                    "dummyFamily",
                                    listOf("dummyGiven1", "dummyGiven2"),
                                    listOf("dummyPrefix1", "dummyPrefix2"),
                                    listOf("dummySuffix1", "dummySuffix2"),
                                    Period(1, 2)
                            ),
                            """
                                {
                                    "use":"dummyUse",
                                    "text":"dummyText",
                                    "family":"dummyFamily",
                                    "given":["dummyGiven1","dummyGiven2"],
                                    "prefix":["dummyPrefix1","dummyPrefix2"],
                                    "suffix":["dummySuffix1","dummySuffix2"],
                                    "period":{"start":1, "end":2}
                                }
                            """.trimIndent()
                    )
            )
}