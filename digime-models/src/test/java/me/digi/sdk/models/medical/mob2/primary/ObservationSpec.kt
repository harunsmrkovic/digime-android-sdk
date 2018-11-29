package me.digi.sdk.models.medical.mob2.primary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.primary.TObservation

class ObservationSpec : ModelTest<Observation>(Observation::class.java) {
    override val emptyTest: Observation? = Observation(
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

    override val jsonObjectTests: List<Pair<Observation?, String>> =
            listOf(
                    Pair(
                            TObservation.obj,
                            TObservation.json
                    )
            )
}