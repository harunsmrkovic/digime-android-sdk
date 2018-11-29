package me.digi.sdk.models.medical.mob2.primary

import me.digi.sdk.models.ModelTest

class GenomicsSpec : ModelTest<Genomics>(Genomics::class.java) {
    override val emptyTest: Genomics? = Genomics(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Genomics?, String>> =
            listOf(
                    Pair(
                            Genomics(
                                    "dummyEntityId",
                                    "dummyAccountEntityId",
                                    1,
                                    2
                            ),
                            """
                                {
                                    "entityid":"dummyEntityId",
                                    "accountentityid":"dummyAccountEntityId",
                                    "createddate":1,
                                    "updateddate":2
                                }
                            """.trimIndent()
                    )
            )
}