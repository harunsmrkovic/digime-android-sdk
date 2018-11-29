package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class Requester(
        @Json(name = "agent")
        val agent: Reference?,

        @Json(name = "onbehalfof")
        val onBehalfOf: Organization?
)