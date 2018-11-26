package me.digi.sdk.models

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson

/**
 * POJO used to parse account from "map.json" ([JFSMap]) file
 */

@JsonClass(generateAdapter = true)
data class JFSAccount(
        @Json(name = "entityid")
        val entityId: String?,

        @Json(name = "serviceid")
        val serviceId: Int = 0,

        @Json(name = "serviceproviderid")
        val serviceProviderId: Int?,

        @Json(name = "serviceprovidername")
        val serviceProviderName: String?,

        @Json(name = "accountid")
        val accountId: String?,

        @Json(name = "accesstoken")
        val accessToken: String?,

        @Json(name = "accesstokensecret")
        val accessTokenSecret: String?,

        @Json(name = "fullname")
        val fullName: String?,

        @Json(name = "username")
        val username: String?,

        @Json(name = "fileurl")
        val avatar: String?,

        @Json(name = "instructionurl")
        val instructionUrl: String?,

        /**
         * UNDEFINED = 0
         * PENDING = 1
         * ACTIVE = 2
         *
         * https://digi-me.atlassian.net/wiki/spaces/ENG/pages/33914908/User+Accounts
         */
        @Json(name = "connectionstatus")
        val connectionStatus: Int?,

        @Json(name = "updateddate")
        val updatedDate: Long?,

        //for finance (see Confluence if other fields needed)

        @Json(name = "accountname")
        val accountName: String?,

        @Json(name = "accountnumber")
        val accountNumber: String?,

        @Json(name = "accountbalance")
        val accountBalance: Double?,

        @Json(name = "accountcurrency")
        val accountCurrency: String?,

        @Json(name = "providerfavicon")
        val providerIcon: String?,

        @Json(name = "providerlogo")
        val providerLogo: String?,

        @Json(name = "providername")
        val providerName: String?,

        @Json(name = "providerid")
        val providerId: Int?,

        @Json(name = "accounttype")
        val accountType: AccountType = AccountType.USER,

        //for finance (see Confluence if other fields needed)
        //TODO These models are in the health_and_fitness
//        @Json(name = "distancepreference")
//        val distanceUnits: DistanceUnit?,
//
//        @Json(name = "waterpreference")
//        val waterUnits: WaterUnit?,
//
//        @Json(name = "weightpreference")
//        val weightUnits: WeightUnit?,
//
//        @Json(name = "lengthpreference")
//        val lengthUnits: LengthUnit?,

        //for music
        @Json(name = "displayname")
        val displayName: String?,

        //for vehicle
        //vehicle registration mark
        @Json(name = "vrm")
        val vrm: String?,

        /**
         * property used for [CADemoMode]
         */
        @Json(name = "syncenabled")
        val syncEnabled: Boolean?,

        // TODO future task: syncenabled will be contained in here
        @Json(name = "sync")
        val syncConfig: JFSAccountSyncConfig?
) {
    companion object {
        enum class AccountType(val id: Int) {
            @Json(name = "0")
            USER(0),
            @Json(name = "1")
            ADMIN(1),
            @Json(name = "2")
            EVENT(2),
            @Json(name = "3")
            GROUP(3),
            @Json(name = "4")
            BANK(4),
            @Json(name = "5")
            CREDIT_CARD(5),
            @Json(name = "6")
            IMPORTED(6);

            companion object {
                @ToJson
                fun toJson(t: AccountType): Int = t.id

                @FromJson
                fun fromJson(value: Int): AccountType = values().find { it.id == value } ?: USER
            }
        }

        fun obscuredAccountId(accountId: String): String {
            val obscureWithWhenLong = "***...*"
            val len = accountId.length
            val sb = StringBuilder()
            if (len > 10) {
                sb.append(obscureWithWhenLong)
            } else {
                for (i in 1..len - 4) {
                    sb.append("*")
                }
            }
            sb.append(accountId.substring(len - 4, len))
            return sb.toString()
        }
    }
}