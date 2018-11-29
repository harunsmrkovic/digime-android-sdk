/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class DaySummaryDistance(
        @Json(name = "totalDistance")
        val totalDistance: Float?,

        @Json(name = "distances")
        val distances: List<Distance>?,

        @Json(name = "goal")
        val goal: Float?
) : ItemDetails.ContentItemDetails