/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.health_and_fitness.*

class GoalsSpec : ModelTest<Goals>(Goals::class.java) {
    override val emptyTest: Goals? = Goals(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Goals?, String>> =
            listOf(
                    Pair(
                            TGoals.obj,
                            TGoals.json
                    )
            )
}

class DistanceSpec : ModelTest<Distance>(Distance::class.java) {
    override val emptyTest: Distance? = Distance(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Distance?, String>> =
            listOf(
                    Pair(
                            TDistance.obj,
                            TDistance.json
                    )
            )
}

class SleepPhaseSpec : ModelTest<SleepPhase>(SleepPhase::class.java) {
    override val emptyTest: SleepPhase? = SleepPhase(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SleepPhase?, String>> =
            listOf(
                    Pair(
                            TSleepPhase.obj,
                            TSleepPhase.json
                    )
            )
}

class SleepSummarySpec : ModelTest<SleepSummary>(SleepSummary::class.java) {
    override val emptyTest: SleepSummary? = SleepSummary(
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SleepSummary?, String>> =
            listOf(
                    Pair(
                            TSleepSummary.obj,
                            TSleepSummary.json
                    )
            )
}

class SleepPhaseSummarySpec : ModelTest<SleepPhaseSummary>(SleepPhaseSummary::class.java) {
    override val emptyTest: SleepPhaseSummary? = SleepPhaseSummary(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SleepPhaseSummary?, String>> =
            listOf(
                    Pair(
                            TSleepPhaseSummary.obj,
                            TSleepPhaseSummary.json
                    )
            )
}

data class SleepDataTypeDummy(val type: SleepDataType)

class SleepDataTypeSpec : ModelTest<SleepDataTypeDummy>(SleepDataTypeDummy::class.java) {
    override val emptyTest: SleepDataTypeDummy? = null

    override val jsonObjectTests: List<Pair<SleepDataTypeDummy?, String>> =
            listOf(
                    Pair(
                            SleepDataTypeDummy(SleepDataType.STAGES),
                            """{"type":"stages"}""".trimIndent()
                    ),
                    Pair(
                            SleepDataTypeDummy(SleepDataType.CLASSIC),
                            """{"type":"classic"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"type":"wrong"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"type":1}""".trimIndent()
                    )
            )
}

