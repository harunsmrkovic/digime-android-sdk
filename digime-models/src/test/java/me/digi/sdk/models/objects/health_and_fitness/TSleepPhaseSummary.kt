package me.digi.sdk.models.objects.health_and_fitness

import me.digi.sdk.models.health_and_fitness.SleepPhaseSummary
import me.digi.sdk.models.objects.ModelTestObject

object TSleepPhaseSummary : ModelTestObject<SleepPhaseSummary>(
        SleepPhaseSummary(
                1,
                2,
                3
        ),
        """
        {
            "count":1,
            "minutes":2,
            "thirtydayavgminutes":3
        }
        """.trimIndent()
)