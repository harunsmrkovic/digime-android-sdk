package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TCodeableConcept
import me.digi.sdk.models.objects.medical.mob2.secondary.TPeriod
import me.digi.sdk.models.objects.medical.mob2.secondary.TReference

class ParticipantSpec : ModelTest<Participant>(Participant::class.java) {
    override val emptyTest: Participant? = Participant(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Participant?, String>> =
            listOf(
                    Pair(
                            Participant(
                                    TCodeableConcept.obj,
                                    TPeriod.obj,
                                    TReference.obj,
                                    "dummyRequired",
                                    "dummyStatus"
                            ),
                            """
                                {
                                    "type":${TCodeableConcept.json},
                                    "period":${TPeriod.json},
                                    "individual":${TReference.json},
                                    "required":"dummyRequired",
                                    "status":"dummyStatus"
                                }
                            """.trimIndent()
                    )
            )
}