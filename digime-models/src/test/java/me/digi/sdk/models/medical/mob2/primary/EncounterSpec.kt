package me.digi.sdk.models.medical.mob2.primary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.primary.TEncounter

class EncounterSpec : ModelTest<Encounter>(Encounter::class.java) {
    override val emptyTest: Encounter? = Encounter(
            null,
            null,
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

    override val jsonObjectTests: List<Pair<Encounter?, String>> =
            listOf(
                    Pair(
                            TEncounter.obj,
                            TEncounter.json
                    )
            )
}