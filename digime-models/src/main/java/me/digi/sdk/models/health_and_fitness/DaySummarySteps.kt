/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class DaySummarySteps(
        @Json(name = "steps")
        val steps: Int?,

        @Json(name = "goal")
        val goal: Int?
) : ItemDetails.ContentItemDetails