package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class BodyCompositionSummary(
        @Json(name = "accountentityid")
        val accountEntityId: String?,

        @Json(name = "bodyWater")
        val bodyWater: Double?,

        @Json(name = "bodyFat")
        val bodyFat: Double?,

        @Json(name = "bodyMassIndex")
        val bodyMassIndex: Double?,

        @Json(name = "boneMass")
        val boneMass: Long?,

        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "entityid")
        val entityId: String?,

        @Json(name = "muscleMass")
        val muscleMass: Long?,

        @Json(name = "weight")
        val weight: Long?
) : ItemDetails.ContentItemDetails