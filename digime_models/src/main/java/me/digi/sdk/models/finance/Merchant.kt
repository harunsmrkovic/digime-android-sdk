/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.finance

import com.google.gson.annotations.SerializedName

/**
 * Merchant that processed a transaction eg. Amazon
 */

data class Merchant(
        @SerializedName("id")
        val id: String,

        @SerializedName("name")
        val name: String
)
