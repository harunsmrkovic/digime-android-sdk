/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json

/**
 * Components associated with Day Summary objects
 */

data class Goals(
        @Json(name = "activeminutes")
        val activeMinutes: Float?,

        @Json(name = "caloriesout")
        val calories: Float?,

        @Json(name = "distance")
        val distance: Float?,

        @Json(name = "floors")
        val floors: Int?,

        @Json(name = "steps")
        val steps: Int?
)

data class Distance(
        @Json(name = "activity")
        val activity: String?,

        @Json(name = "distance")
        val distance: Float?
)

data class SleepPhase(
        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "level")
        val phase: String?,

        @Json(name = "seconds")
        val seconds: Int?
)

data class SleepSummary(
        // "classic" data style
        @Json(name = "asleep")
        val asleep: SleepPhaseSummary?,

        @Json(name = "restless")
        val restless: SleepPhaseSummary?,

        @Json(name = "awake")
        val awake: SleepPhaseSummary?,

        // "stages" data style
        @Json(name = "deep")
        val deep: SleepPhaseSummary?,

        @Json(name = "light")
        val light: SleepPhaseSummary?,

        @Json(name = "rem")
        val rem: SleepPhaseSummary?,

        @Json(name = "wake")
        val wake: SleepPhaseSummary?
)

data class SleepPhaseSummary(
        @Json(name = "count")
        val count: Int?,

        @Json(name = "minutes")
        val minutes: Int?,

        @Json(name = "thirtydayavgminutes")
        val thirtyDayAvgMinutes: Int?
)

// https://dev.fitbit.com/reference/web-api/sleep/
enum class SleepDataType {
    // 30 second granularity
    @Json(name = "stages")
    STAGES,
    // 60 second granularity
    @Json(name = "classic")
    CLASSIC
}
