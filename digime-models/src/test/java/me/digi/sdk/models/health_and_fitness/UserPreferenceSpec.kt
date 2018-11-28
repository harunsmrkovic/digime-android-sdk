package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

data class WaterUnitDummy(val unit: WaterUnit)

class WaterUnitSpec : ModelTest<WaterUnitDummy>(WaterUnitDummy::class.java, object : ModelParam<WaterUnitDummy> {
    override val jsonTests: List<Pair<WaterUnitDummy?, String>> = emptyList()

    override val emptyTest: WaterUnitDummy? = null

    override val jsonObjectTests: List<Pair<WaterUnitDummy?, String>> =
            listOf(
                    Pair(
                            WaterUnitDummy(WaterUnit.MILLILITERS),
                            """{"unit":0}""".trimIndent()
                    ),
                    Pair(
                            WaterUnitDummy(WaterUnit.FLUID_OUNCE),
                            """{"unit":1}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":"wrong"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":99}""".trimIndent()
                    )
            )
})

data class LengthUnitDummy(val unit: LengthUnit)

class LengthUnitSpec : ModelTest<LengthUnitDummy>(LengthUnitDummy::class.java, object : ModelParam<LengthUnitDummy> {
    override val jsonTests: List<Pair<LengthUnitDummy?, String>> = emptyList()

    override val emptyTest: LengthUnitDummy? = null

    override val jsonObjectTests: List<Pair<LengthUnitDummy?, String>> =
            listOf(
                    Pair(
                            LengthUnitDummy(LengthUnit.CM),
                            """{"unit":0}""".trimIndent()
                    ),
                    Pair(
                            LengthUnitDummy(LengthUnit.INCHES),
                            """{"unit":1}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":"wrong"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":99}""".trimIndent()
                    )
            )
})

data class DistanceUnitDummy(val unit: DistanceUnit)

class DistanceUnitSpec : ModelTest<DistanceUnitDummy>(DistanceUnitDummy::class.java, object : ModelParam<DistanceUnitDummy> {
    override val jsonTests: List<Pair<DistanceUnitDummy?, String>> = emptyList()

    override val emptyTest: DistanceUnitDummy? = null

    override val jsonObjectTests: List<Pair<DistanceUnitDummy?, String>> =
            listOf(
                    Pair(
                            DistanceUnitDummy(DistanceUnit.KM),
                            """{"unit":0}""".trimIndent()
                    ),
                    Pair(
                            DistanceUnitDummy(DistanceUnit.MILES),
                            """{"unit":1}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":"wrong"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":99}""".trimIndent()
                    )
            )
})

data class WeightUnitDummy(val unit: WeightUnit)

class WeightUnitSpec : ModelTest<WeightUnitDummy>(WeightUnitDummy::class.java, object : ModelParam<WeightUnitDummy> {
    override val jsonTests: List<Pair<WeightUnitDummy?, String>> = emptyList()

    override val emptyTest: WeightUnitDummy? = null

    override val jsonObjectTests: List<Pair<WeightUnitDummy?, String>> =
            listOf(
                    Pair(
                            WeightUnitDummy(WeightUnit.KG),
                            """{"unit":0}""".trimIndent()
                    ),
                    Pair(
                            WeightUnitDummy(WeightUnit.LBS),
                            """{"unit":1}""".trimIndent()
                    ),
                    Pair(
                            WeightUnitDummy(WeightUnit.STONE),
                            """{"unit":2}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":"wrong"}""".trimIndent()
                    ),
                    Pair(
                            null,
                            """{"unit":99}""".trimIndent()
                    )
            )
})

