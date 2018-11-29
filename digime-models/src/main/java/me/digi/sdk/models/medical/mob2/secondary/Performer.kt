package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class Performer(
        @Json(name = "actor")
        val actor: Reference?,

        @Json(name = "onbehalfof")
        val onBehalfOf: Organization?,

        @Json(name = "role")
        val role: CodeableConcept?
)