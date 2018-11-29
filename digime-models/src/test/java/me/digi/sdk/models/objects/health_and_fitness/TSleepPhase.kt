/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.objects.health_and_fitness

import me.digi.sdk.models.health_and_fitness.SleepPhase
import me.digi.sdk.models.objects.ModelTestObject

object TSleepPhase : ModelTestObject<SleepPhase>(
        SleepPhase(
                1,
                "dummyLevel",
                2
        ),
        """
        {
            "createddate":1,
            "level":"dummyLevel",
            "seconds":2
        }
        """.trimIndent()
)