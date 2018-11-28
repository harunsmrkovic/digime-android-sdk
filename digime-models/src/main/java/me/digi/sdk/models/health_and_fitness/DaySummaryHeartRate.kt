package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class DaySummaryHeartRate(
        @Json(name = "restingheartrate")
        val restingHeartRate: Float?,

        @Json(name = "heartratezones")
        val heartRateZones: List<HeartRateZone>?
) : ItemDetails.ContentItemDetails