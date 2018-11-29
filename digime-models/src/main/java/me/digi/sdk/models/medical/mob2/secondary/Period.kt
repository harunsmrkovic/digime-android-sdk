package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class Period(
        @Json(name = "start")
        val start: Long?,

        @Json(name = "end")
        val end: Long?
)