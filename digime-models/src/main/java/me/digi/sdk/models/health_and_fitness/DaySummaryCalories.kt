/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class DaySummaryCalories(
        @Json(name = "activityCalories")
        val activityCalories: Float?,

        @Json(name = "caloriesBmr")
        val caloriesBmr: Float?,

        @Json(name = "marginalCalories")
        val marginalCalories: Float?,

        @Json(name = "caloriesOut")
        val caloriesOut: Float?,

        @Json(name = "goal")
        val goal: Float?
) : ItemDetails.ContentItemDetails