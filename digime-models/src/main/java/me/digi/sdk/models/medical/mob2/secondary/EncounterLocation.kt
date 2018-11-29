package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class EncounterLocation(
        @Json(name = "location")
        val location: Location?,

        @Json(name = "status")
        val status: String?,

        @Json(name = "period")
        val period: Period?
)