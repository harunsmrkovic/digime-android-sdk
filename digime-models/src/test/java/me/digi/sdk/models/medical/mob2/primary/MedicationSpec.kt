package me.digi.sdk.models.medical.mob2.primary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.primary.TMedication

class MedicationSpec : ModelTest<Medication>(Medication::class.java) {
    override val emptyTest: Medication? = Medication(
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

    override val jsonObjectTests: List<Pair<Medication?, String>> =
            listOf(
                    Pair(
                            TMedication.obj,
                            TMedication.json
                    )
            )
}