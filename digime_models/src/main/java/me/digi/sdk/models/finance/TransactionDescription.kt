/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.finance

import com.google.gson.annotations.SerializedName

/**
 * Description:
 */

data class TransactionDescription(
        @SerializedName("original")
        val originalRef: String?,

        @SerializedName("simple")
        val simpleRef: String? //where present, seems to be the same as the merchant name
)
