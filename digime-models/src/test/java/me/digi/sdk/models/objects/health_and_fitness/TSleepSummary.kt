/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.objects.health_and_fitness

import me.digi.sdk.models.health_and_fitness.SleepSummary
import me.digi.sdk.models.objects.ModelTestObject

object TSleepSummary : ModelTestObject<SleepSummary>(
        SleepSummary(
                TSleepPhaseSummary.obj,
                TSleepPhaseSummary.obj,
                TSleepPhaseSummary.obj,
                TSleepPhaseSummary.obj,
                TSleepPhaseSummary.obj,
                TSleepPhaseSummary.obj,
                TSleepPhaseSummary.obj
        ),
        """
        {
            "asleep":${TSleepPhaseSummary.json},
            "restless":${TSleepPhaseSummary.json},
            "awake":${TSleepPhaseSummary.json},
            "deep":${TSleepPhaseSummary.json},
            "light":${TSleepPhaseSummary.json},
            "rem":${TSleepPhaseSummary.json},
            "wake":${TSleepPhaseSummary.json}
        }
        """.trimIndent()
)