package me.digi.sdk.models.finance

import com.squareup.moshi.Json

/**
 * Merchant that processed a transaction eg. Amazon
 */

data class Merchant(
        @Json(name = "id")
        val id: String?,

        @Json(name = "name")
        val name: String?
)