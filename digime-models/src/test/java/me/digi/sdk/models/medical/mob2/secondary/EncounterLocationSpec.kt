package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TEncounterLocation

class EncounterLocationSpec : ModelTest<EncounterLocation>(EncounterLocation::class.java) {
    override val emptyTest: EncounterLocation? = EncounterLocation(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<EncounterLocation?, String>> =
            listOf(
                    Pair(
                            TEncounterLocation.obj,
                            TEncounterLocation.json
                    )
            )
}