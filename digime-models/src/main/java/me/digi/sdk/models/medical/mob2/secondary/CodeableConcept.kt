package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class CodeableConcept(
        @Json(name = "coding")
        val coding: List<Coding>?,

        @Json(name = "text")
        val text: String?
)