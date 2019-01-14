/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.objects.health_and_fitness

import me.digi.sdk.models.health_and_fitness.Duration
import me.digi.sdk.models.objects.ModelTestObject

object TDuration : ModelTestObject<Duration>(
        Duration(
                1,
                2,
                3
        ),
        """
        {
            "active":1,
            "original":2,
            "total":3
        }
        """.trimIndent()
)