package me.digi.sdk.models.medical.mob2.secondary

import com.squareup.moshi.Json

data class Reaction(
        @Json(name = "substance")
        val substance: CodeableConcept?,

        @Json(name = "onset")
        val onset: Long?,

        @Json(name = "manifestation")
        val manifestation: List<CodeableConcept>?,

        @Json(name = "note")
        val note: List<Annotation>?
)