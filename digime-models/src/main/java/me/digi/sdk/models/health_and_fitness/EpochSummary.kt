package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class EpochSummary(
        @Json(name = "accountentityid")
        val accountEntityId: String?,

        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "distance")
        val distance: Long?,

        @Json(name = "duration")
        val duration: Long?,

        @Json(name = "entityid")
        val entityId: String?,

        @Json(name = "id")
        val id: String?,

        @Json(name = "intensity")
        val intensity: String?,

        @Json(name = "kilocalories")
        val kiloCalories: Long?,

        @Json(name = "maxmotionintensity")
        val maxMotionIntensity: Long?,

        @Json(name = "meanmotionintensity")
        val meanMotionIntensity: Long?,

        @Json(name = "met")
        val met: Long?,

        @Json(name = "steps")
        val steps: Long?,

        @Json(name = "time")
        val time: Long?,

        @Json(name = "type")
        val type: String?
) : ItemDetails.ContentItemDetails