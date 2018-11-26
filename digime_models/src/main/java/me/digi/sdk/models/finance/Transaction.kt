/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.finance


import com.google.gson.annotations.SerializedName

import me.digi.sdk.models.ContentItemDetails

/**
 * Financial transaction object, JFS Ontology derived from Yodelee Transaction object
 */

data class Transaction(
        @SerializedName("container")
        val container: String?,

        @SerializedName("id")
        val id: String?,

        @SerializedName("entityid")
        val entityId: String?,

        /**
         * jfs account id, which is converted to [Account.id]
         */
        @SerializedName("accountentityid")
        val accountEntityId: String?,

        /**
         * mapped to [ContentItem.text2] together with [.currency]
         */
        @JvmField @SerializedName("amount")
        val amount: Float?,

        /**
         * mapped as a currency symbol to [ContentItem.text2] together with [.amount]
         */
        @JvmField @SerializedName("currency")
        val currency: String?,

        @SerializedName("runningbalance")
        val runningBalance: Double?,

        @SerializedName("runningbalancecurrency")
        val runningBalanceCurrency: String?,

        /**
         * mapped to [ContentItem.text3]
         */
        @SerializedName("originalref")
        val originalRef: String?,

        @SerializedName("simpleref")
        val simpleRef: String?,

        /**
         * compared to "credit" type and mapped to [ContentItem.flags]
         */
        @SerializedName("basetype")
        val baseType: String?,

        @SerializedName("type")
        val type: String?,

        @SerializedName("subtype")
        val subType: String?,

        @SerializedName("category")
        val category: String?,

        @SerializedName("categoryid")
        val categoryId: Int?,

        @SerializedName("highlevelcategoryid")
        val highLevelCategoryId: Int?,

        @SerializedName("categorysource")
        val categorySource: String?,

        @SerializedName("categorytype")
        val categoryType: String?,

        @SerializedName("checknumber")
        val checkNumber: String?,

        @SerializedName("consumerref")
        val consumerRef: String?,

        @SerializedName("merchantid")
        val merchantId: String?,

        /**
         * mapped to [ContentItem.text1]
         */
        @SerializedName("merchantname")
        val merchantName: String?,

        @SerializedName("merchantaddress1")
        val merchantAddress1: String?,

        @SerializedName("merchantaddress2")
        val merchantAddress2: String?,

        @SerializedName("merchantcity")
        val merchantCity: String?,

        @SerializedName("merchantcountry")
        val merchantCountry: String?,

        @SerializedName("createddate")
        val createdDate: Long?,

        @SerializedName("transactiondate")
        val transactionDate: Long?,

        @SerializedName("postdate")
        val postDate: Long?,

        @SerializedName("ismanual")
        val isManual: Boolean?,

        @SerializedName("status")
        val status: String?
) : ContentItemDetails {
    val isCredit: Boolean
        get() = baseType!!.equals("credit", ignoreCase = true)

}
