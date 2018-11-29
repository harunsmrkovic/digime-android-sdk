package me.digi.sdk.models.medical.mob2.primary

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails
import me.digi.sdk.models.medical.mob2.secondary.CodeableConcept
import me.digi.sdk.models.medical.mob2.secondary.Identifier
import me.digi.sdk.models.medical.mob2.secondary.Reaction
import me.digi.sdk.models.medical.mob2.secondary.Reference

data class AllergyIntolerance(
        @Json(name = "entityid")
        val entityID: String?,

        @Json(name = "accountentityid")
        var accountEntityId: String?,

        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "updateddate")
        val updatedDate: Long?,

        @Json(name = "identifier")
        val identifier: List<Identifier>?,

        @Json(name = "clinicalstatus")
        val clinicalStatus: String?,

        @Json(name = "verificationstatus")
        val verificationStatus: String?,

        @Json(name = "criticality")
        val criticality: String?,

        @Json(name = "code")
        val code: CodeableConcept?,

        @Json(name = "onsetdatetime")
        val onsetDateTime: Long?,

        @Json(name = "asserteddate")
        val assertedDate: Long?,

        @Json(name = "recorder")
        val recorder: Reference?,

        @Json(name = "lastoccurence")
        val lastOccurence: Long?,

        @Json(name = "note")
        val note: List<Annotation>?,

        @Json(name = "reaction")
        val reaction: List<Reaction>?
) : ItemDetails.ContentItemDetails