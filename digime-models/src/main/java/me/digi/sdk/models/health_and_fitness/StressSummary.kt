package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class StressSummary(
        @Json(name = "accountentityid")
        val accountEntityId: String?,

        @Json(name = "entityid")
        val entityId: String?,

        @Json(name = "id")
        val id: String?,

        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "duration")
        val duration: Long?,

        @Json(name = "calendarDate")
        val calendarDate: Long?
) : ItemDetails.ContentItemDetails