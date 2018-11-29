package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TOrganization
import me.digi.sdk.models.objects.medical.mob2.secondary.TReference

class RequesterSpec : ModelTest<Requester>(Requester::class.java) {
    override val emptyTest: Requester? = Requester(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Requester?, String>> =
            listOf(
                    Pair(
                            Requester(
                                    TReference.obj,
                                    TOrganization.obj
                            ),
                            """
                                {
                                    "agent":${TReference.json},
                                    "onbehalfof":${TOrganization.json}
                                }
                            """.trimIndent()
                    )
            )
}