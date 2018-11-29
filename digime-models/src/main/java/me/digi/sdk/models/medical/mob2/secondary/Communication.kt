package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class Communication(
        @Json(name = "language")
        val language: CodeableConcept?,

        @Json(name = "preferred")
        val preferred: Boolean?
)