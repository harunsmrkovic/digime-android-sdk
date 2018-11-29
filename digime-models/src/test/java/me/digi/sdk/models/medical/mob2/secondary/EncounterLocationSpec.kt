package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TLocation
import me.digi.sdk.models.objects.medical.mob2.secondary.TPeriod

class EncounterLocationSpec : ModelTest<EncounterLocation>(EncounterLocation::class.java) {
    override val emptyTest: EncounterLocation? = EncounterLocation(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<EncounterLocation?, String>> =
            listOf(
                    Pair(
                            EncounterLocation(
                                    TLocation.obj,
                                    "dummyStatus",
                                    TPeriod.obj
                            ),
                            """
                                {
                                    "location":${TLocation.json},
                                    "status":"dummyStatus",
                                    "period":${TPeriod.json}
                                }
                            """.trimIndent()
                    )
            )
}