package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails
import me.digi.sdk.models.MediaResource

/**
 * Badge (Achievement) JFS entity
 */

data class Badge(
        @Json(name = "id")
        val id: String?,

        @Json(name = "entityid")
        val entityId: String?,

        @Json(name = "accountentityid")
        val accountEntityId: String?,

        @Json(name = "updateddate")
        val updatedDate: Long?,

        @Json(name = "category")
        val category: String?,

        @Json(name = "timesachieved")
        val timesAchieved: Int?,

        @Json(name = "value")
        val value: Int?,

        /**
         * mapped to [ContentItem.text1]
         */
        @Json(name = "name")
        val name: String?,

        @Json(name = "shortname")
        val shortName: String?,

        @Json(name = "description")
        val description: String?,

        @Json(name = "shortdescription")
        val shortDescription: String?,

        /**
         * mapped to [ContentItem.text2]
         */
        @Json(name = "earnedmessage")
        val earnedMessage: String?,

        @Json(name = "marketingdescription")
        val marketingDescription: String?,

        /**
         * mapped to [ContentItem.text3]
         */
        @Json(name = "mobiledescription")
        val mobileDescription: String?,

        @Json(name = "sharetext")
        val shareText: String?,

        @Json(name = "resources")
        val resources: Set<MediaResource>?,

        @Json(name = "gradientendcolor")
        val gradientEndColor: String?,

        @Json(name = "gradientstartcolor")
        val gradientStartColor: String?
) : ItemDetails.ContentItemDetails