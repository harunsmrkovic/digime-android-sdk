/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class DaySummaryFloorsClimbed(
        @Json(name = "floors")
        val floors: Int?,

        @Json(name = "goal")
        val goal: Int?
) : ItemDetails.ContentItemDetails