/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.medical.mob2.primary

import com.squareup.moshi.Json

data class Genomics(
        @Json(name = "entityid")
        val entityID: String?,

        @Json(name = "accountentityid")
        var accountEntityId: String?,

        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "updateddate")
        val updatedDate: Long?
)