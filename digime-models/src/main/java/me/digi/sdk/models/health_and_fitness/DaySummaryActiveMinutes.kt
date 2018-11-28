package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

data class DaySummaryActiveMinutes(
        @Json(name = "sedentaryMinutes")
        val sedentaryMinutes: Float?,

        @Json(name = "lightlyActiveMinutes")
        val lightlyActiveMinutes: Float?,

        @Json(name = "fairlyActiveMinutes")
        val fairlyActiveMinutes: Float?,

        @Json(name = "veryActiveMinutes")
        val veryActiveMinutes: Float?,

        @Json(name = "goal")
        val goal: Float?
) : ItemDetails.ContentItemDetails {
    // documentation not clear how activeminutes goal relates to the activity zones
    // https://help.fitbit.com/articles/en_US/Help_article/1379
    // but anecdotally it seems to be the sum of fairly active and very active
    val activeMinutes: Float? =
            when (Pair(fairlyActiveMinutes, veryActiveMinutes)) {
                Pair(null, null) -> null
                else -> (fairlyActiveMinutes ?: 0f) + (veryActiveMinutes ?: 0f)
            }
}