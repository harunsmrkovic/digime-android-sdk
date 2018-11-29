/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.ModelTest
import org.junit.Assert
import org.junit.Test

class DaySummaryActiveMinutesSpec : ModelTest<DaySummaryActiveMinutes>(DaySummaryActiveMinutes::class.java) {
    override val emptyTest: DaySummaryActiveMinutes? = DaySummaryActiveMinutes(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<DaySummaryActiveMinutes?, String>> =
            listOf(
                    Pair(
                            DaySummaryActiveMinutes(
                                    1.5f,
                                    2.5f,
                                    3.5f,
                                    4.5f,
                                    5.5f
                            ),
                            """
                                {
                                    "sedentaryMinutes":1.5,
                                    "lightlyActiveMinutes":2.5,
                                    "fairlyActiveMinutes":3.5,
                                    "veryActiveMinutes":4.5,
                                    "goal":5.5
                                }
                            """.trimIndent()
                    ),
                    Pair(
                            DaySummaryActiveMinutes(
                                    1f,
                                    2f,
                                    3f,
                                    4f,
                                    5f
                            ),
                            """
                                {
                                    "sedentaryMinutes":1,
                                    "lightlyActiveMinutes":2,
                                    "fairlyActiveMinutes":3,
                                    "veryActiveMinutes":4,
                                    "goal":5
                                }
                            """.trimIndent()
                    )
            )

    @Test
    fun `when fairlyActiveMinutes and veryActiveMinutes are null, activeMinutes should be null`() {
        val fairlyActiveMinutes = null
        val veryActiveMinutes = null
        Assert.assertNull(
                emptyTest!!
                        .copy(fairlyActiveMinutes = fairlyActiveMinutes, veryActiveMinutes = veryActiveMinutes)
                        .activeMinutes
        )
    }

    @Test
    fun `when fairlyActiveMinutes is null and veryActiveMinutes is not null, activeMinutes should be veryActiveMinutes`() {
        val fairlyActiveMinutes = null
        val veryActiveMinutes = 1f
        Assert.assertEquals(
                veryActiveMinutes,

                emptyTest!!
                        .copy(fairlyActiveMinutes = fairlyActiveMinutes, veryActiveMinutes = veryActiveMinutes)
                        .activeMinutes
        )
    }

    @Test
    fun `when fairlyActiveMinutes is not null and veryActiveMinutes is null, activeMinutes should be fairlyActiveMinutes`() {
        val fairlyActiveMinutes = 1f
        val veryActiveMinutes = null
        Assert.assertEquals(
                fairlyActiveMinutes,
                emptyTest!!
                        .copy(fairlyActiveMinutes = fairlyActiveMinutes, veryActiveMinutes = veryActiveMinutes)
                        .activeMinutes
        )
    }

    @Test
    fun `when fairlyActiveMinutes and veryActiveMinutes are not null, activeMinutes should be the sum of both`() {
        val fairlyActiveMinutes = 1f
        val veryActiveMinutes = 1f
        Assert.assertEquals(
                fairlyActiveMinutes + veryActiveMinutes,
                emptyTest!!
                        .copy(fairlyActiveMinutes = fairlyActiveMinutes, veryActiveMinutes = veryActiveMinutes)
                        .activeMinutes
        )
    }
}