package me.digi.sdk.models.objects.medical.mob2.secondary

import me.digi.sdk.models.medical.mob2.secondary.Repeat
import me.digi.sdk.models.objects.ModelTestObject

object TRepeat : ModelTestObject<Repeat>(
        Repeat(
                1,
                2,
                "dummyPeriodUnit",
                TPeriod.obj
        ),
        """
        {
            "frequency":1,
            "period":2,
            "periodunit":"dummyPeriodUnit",
            "boundsperiod":${TPeriod.json}
        }
        """.trimIndent()
)