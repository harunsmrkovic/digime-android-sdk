package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class Quantity(
        @Json(name = "value")
        val value: Long?,

        @Json(name = "unit")
        val unit: String?,

        @Json(name = "system")
        val system: String?,

        @Json(name = "code")
        val code: String?
)