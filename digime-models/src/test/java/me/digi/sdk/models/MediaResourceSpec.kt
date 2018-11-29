package me.digi.sdk.models

import org.junit.Assert
import org.junit.Test

class AspectRatioSpec : ModelTest<AspectRatio>(AspectRatio::class.java) {
    override val emptyTest: AspectRatio? = AspectRatio(
            0.0,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<AspectRatio?, String>> =
            listOf(
                    Pair(
                            AspectRatio(
                                    1.5,
                                    "dummyActual",
                                    "dummyClosest"
                            ),
                            """
                                {
                                    "accuracy":1.5,
                                    "actual":"dummyActual",
                                    "closest":"dummyClosest"
                                }
                            """.trimIndent()
                    ),
                    Pair(
                            AspectRatio(
                                    1.0,
                                    "dummyActual",
                                    "dummyClosest"
                            ),
                            """
                                {
                                    "accuracy":1,
                                    "actual":"dummyActual",
                                    "closest":"dummyClosest"
                                }
                            """.trimIndent()
                    )
            )
}

class MediaResourceSpec : ModelTest<MediaResource>(MediaResource::class.java) {
    override val emptyTest: MediaResource? = MediaResource(
            null,
            0,
            0,
            null,
            null,
            0,
            null
    )

    override val jsonObjectTests: List<Pair<MediaResource?, String>> =
            listOf(
                    Pair(
                            MediaResource(
                                    AspectRatio(1.5, "dummyActual", "dummyClosest"),
                                    1,
                                    2,
                                    "application/dummyType",
                                    "dummyResize",
                                    3,
                                    "dummyUrl"
                            ),
                            """
                                {
                                    "aspectratio":{
                                        "accuracy":1.5,
                                        "actual":"dummyActual",
                                        "closest":"dummyClosest"
                                    },
                                    "height":1,
                                    "width":2,
                                    "mimetype":"application/dummyType",
                                    "resize":"dummyResize",
                                    "type":3,
                                    "url":"dummyUrl"
                                }
                            """.trimIndent()
                    )
            )

    @Test
    fun `when comparing two objects should compare using the resolution`() {
        val generateMediaResource: (Int) -> MediaResource = { size ->
            MediaResource(
                    null,
                    size,
                    size,
                    null,
                    null,
                    0,
                    null
            )
        }
        Assert.assertTrue(generateMediaResource(3) > generateMediaResource(2))
        Assert.assertFalse(generateMediaResource(2) > generateMediaResource(3))
        Assert.assertTrue(generateMediaResource(2) < generateMediaResource(3))
        Assert.assertFalse(generateMediaResource(3) < generateMediaResource(2))
        Assert.assertTrue(generateMediaResource(2) == generateMediaResource(2))
        Assert.assertFalse(generateMediaResource(2) == generateMediaResource(3))
    }
}