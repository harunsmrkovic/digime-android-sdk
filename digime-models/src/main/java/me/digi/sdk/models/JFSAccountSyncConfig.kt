package me.digi.sdk.models

import com.squareup.moshi.Json

/**
 * Sync configuration for an account
 */

data class JFSAccountSyncConfig(
        @Json(name = "type")
        val type: SyncType
)

enum class SyncType(val id: Int) {
    @Json(name = "auto")
    AUTO(0),
    @Json(name = "manual")
    MANUAL(1),
    // this one is not actually used by CCS, only for local use
    @Json(name = "default")
    DEFAULT(2);

    companion object {
        fun getTypeById(id: Int): SyncType = values().find { it.id == id } ?: DEFAULT
    }
}