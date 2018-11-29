package me.digi.sdk.models.medical.mob2.primary

import com.squareup.moshi.Json
import me.digi.sdk.models.medical.mob2.secondary.CodeableConcept
import me.digi.sdk.models.medical.mob2.secondary.Identifier
import me.digi.sdk.models.medical.mob2.secondary.Location
import me.digi.sdk.models.medical.mob2.secondary.Performer

data class Procedure(
        @Json(name = "entityid")
        val entityID: String?,

        @Json(name = "accountentityid")
        var accountEntityId: String?,

        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "updateddate")
        val updatedDate: Long?,

        @Json(name = "id")
        val id: String?,

        @Json(name = "identifier")
        val identifier: List<Identifier>?,

        @Json(name = "status")
        val status: String?,

        @Json(name = "notdone")
        val notDone: Boolean?,

        @Json(name = "code")
        val code: CodeableConcept?,

        @Json(name = "performeddatetime")
        val performedDateTime: Long?,

        @Json(name = "performer")
        val performer: List<Performer>?,

        @Json(name = "location")
        val location: Location?
)