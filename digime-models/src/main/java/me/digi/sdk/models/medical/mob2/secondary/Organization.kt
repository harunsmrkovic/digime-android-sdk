package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class Organization(
        @Json(name = "id")
        val id: String?,

        @Json(name = "identifier")
        val identifier: List<Identifier>?,

        @Json(name = "active")
        val active: Boolean?,

        @Json(name = "type")
        val type: List<CodeableConcept>?
)