package me.digi.sdk.models.medical.mob2.secondary

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.medical.mob2.secondary.TUdi

class UdiSpec : ModelTest<Udi>(Udi::class.java) {
    override val emptyTest: Udi? = Udi(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Udi?, String>> =
            listOf(
                    Pair(
                            TUdi.obj,
                            TUdi.json
                    )
            )
}