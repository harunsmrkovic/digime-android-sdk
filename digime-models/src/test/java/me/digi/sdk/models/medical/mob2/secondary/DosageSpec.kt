/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TDosage

class DosageSpec : ModelTest<Dosage>(Dosage::class.java) {
    override val emptyTest: Dosage? = Dosage(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Dosage?, String>> =
            listOf(
                    Pair(
                            TDosage.obj,
                            TDosage.json
                    )
            )
}