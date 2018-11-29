/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.finance

import com.squareup.moshi.Json

data class TransactionDescription(
        @Json(name = "original")
        val originalRef: String?,

        @Json(name = "simple")
        //where present, seems to be the same as the merchant name
        val simpleRef: String?
)