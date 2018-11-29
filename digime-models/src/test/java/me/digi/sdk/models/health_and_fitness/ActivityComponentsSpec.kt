package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest

class LevelSpec : ModelTest<Level>(Level::class.java) {
    override val emptyTest: Level? = Level(
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Level?, String>> =
            listOf(
                    Pair(
                            Level(
                                    "dummyName",
                                    1.5f
                            ),
                            """
                                {
                                    "name":"dummyName",
                                    "minutes":1.5
                                }
                            """.trimIndent()
                    )
            )
}

class ManualValuesSpec : ModelTest<ManualValues>(ManualValues::class.java) {
    override val emptyTest: ManualValues? = ManualValues(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<ManualValues?, String>> =
            listOf(
                    Pair(
                            ManualValues(
                                    true,
                                    true,
                                    true
                            ),
                            """
                                {
                                    "calories":true,
                                    "distance":true,
                                    "steps":true
                                }
                            """.trimIndent()
                    )
            )
}

class SourceSpec : ModelTest<Source>(Source::class.java) {
    override val emptyTest: Source? = Source(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Source?, String>> =
            listOf(
                    Pair(
                            Source(
                                    "dummyId",
                                    "dummyName",
                                    "dummyType",
                                    "dummyUrl"
                            ),
                            """
                                {
                                    "id":"dummyId",
                                    "name":"dummyName",
                                    "type":"dummyType",
                                    "url":"dummyUrl"
                                }
                            """.trimIndent()
                    )
            )
}

class DurationSpec : ModelTest<Duration>(Duration::class.java) {
    override val emptyTest: Duration? = Duration(
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Duration?, String>> =
            listOf(
                    Pair(
                            Duration(
                                    1,
                                    2,
                                    3
                            ),
                            """
                                {
                                    "active":1,
                                    "original":2,
                                    "total":3
                                }
                            """.trimIndent()
                    )
            )
}

class HeartRateZoneSpec : ModelTest<HeartRateZone>(HeartRateZone::class.java) {
    override val emptyTest: HeartRateZone? = HeartRateZone(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<HeartRateZone?, String>> =
            listOf(
                    Pair(
                            HeartRateZone(
                                    1.5f,
                                    2.5f,
                                    3.5f,
                                    "dummyName",
                                    4.5f
                            ),
                            """
                                {
                                    "max":1.5,
                                    "min":2.5,
                                    "minutes":3.5,
                                    "name":"dummyName",
                                    "caloriesout":4.5
                                }
                            """.trimIndent()
                    )
            )
}
