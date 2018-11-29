/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.health_and_fitness.THeartRateZone

class DaySummaryHeartRateSpec : ModelTest<DaySummaryHeartRate>(DaySummaryHeartRate::class.java) {
    override val emptyTest: DaySummaryHeartRate? = DaySummaryHeartRate(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummaryHeartRate?, String>> =
            listOf(
                    Pair(
                            DaySummaryHeartRate(
                                    1.5f,
                                    listOf(
                                            THeartRateZone.obj
                                    )
                            ),
                            """
                                {
                                    "restingheartrate":1.5,
                                    "heartratezones":[
                                        ${THeartRateZone.json}
                                    ]
                                }
                            """.trimIndent()
                    )
            )
}