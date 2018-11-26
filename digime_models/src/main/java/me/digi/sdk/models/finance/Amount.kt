/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.finance

import com.google.gson.annotations.SerializedName

/**
 * Description:
 */

data class Amount(
        @SerializedName("amount")
        val amount: Float,

        @SerializedName("currency")
        val currency: String
)
