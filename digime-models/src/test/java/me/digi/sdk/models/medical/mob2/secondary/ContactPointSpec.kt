package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TContactPoint

class ContactPointSpec : ModelTest<ContactPoint>(ContactPoint::class.java) {
    override val emptyTest: ContactPoint? = ContactPoint(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<ContactPoint?, String>> =
            listOf(
                    Pair(
                            TContactPoint.obj,
                            TContactPoint.json
                    )
            )
}