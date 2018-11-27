package me.digi.sdk.models.music

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class PlayHistory(
        @Json(name = "accountentityid")
        val accountEntityId: String?,

        @Json(name = "entityid")
        val entityId: String?,

        @Json(name = "createddate")
        val playedAt: Long?,

        @Json(name = "track")
        val track: Track?
) : ItemDetails.ContentItemDetails