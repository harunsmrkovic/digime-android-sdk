/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import com.squareup.moshi.Json
import me.digi.sdk.models.ItemDetails

/**
 * Sleep log data (so in fact you could have more than one of these in a day)
 */

data class DaySummarySleep(
        @Json(name = "id")
        val id: String?,

        @Json(name = "entityid")
        val entityId: String?,

        @Json(name = "accountentityid")
        val accountEntityId: String?,

        @Json(name = "type")
        val type: SleepDataType?,

        @Json(name = "createddate")
        val createdDate: Long?,

        @Json(name = "startdate")
        val startDate: Long?,

        @Json(name = "enddate")
        val endDate: Long?,

        @Json(name = "efficiency")
        val efficiency: Int?,

        // Milliseconds
        @Json(name = "duration")
        val duration: Int?,

        @Json(name = "infocode")
        val infoCode: Int?,

        @Json(name = "ismainsleep")
        val isMainSleep: Boolean?,

        @Json(name = "levels")
        val phases: List<SleepPhase>?,

        @Json(name = "summary")
        val summary: SleepSummary?,

        @Json(name = "minutesafterwakeup")
        val minutesAfterWakeUp: Int?,

        @Json(name = "minutesasleep")
        val minutesAsleep: Int?,

        @Json(name = "minutesawake")
        val minutesAwake: Int?,

        // typically 0 when log auto-created
        @Json(name = "minutestofallasleep")
        val minutesToFallAsleep: Int?,

        @Json(name = "timeinbed")
        val timeInBed: Int?,

        @Json(name = "awakeduration")
        val awakeduration: Long?,

        @Json(name = "deepsleepduration")
        val deepsleepduration: Long?,

        @Json(name = "lightsleepduration")
        val lightsleepduration: Long?
) : ItemDetails.ContentItemDetails