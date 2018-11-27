package me.digi.sdk.models.music

import me.digi.sdk.models.AspectRatio
import me.digi.sdk.models.MediaResource
import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest
import org.junit.Assert
import org.junit.Test

class TrackSpec : ModelTest<Track>(Track::class.java, object : ModelParam<Track> {
    override val emptyTest: Track? = Track(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Track?, String>> =
            listOf(
                    Pair(
                            Track(
                                    "dummyaccountentityid",
                                    "dummyentityid",
                                    "dummyid",
                                    "dummyname",
                                    1,
                                    2,
                                    3,
                                    "dummylink",
                                    listOf(
                                            Artist(
                                                    "dummyAccountEntityId",
                                                    "dummyEntityId",
                                                    "dummyId",
                                                    "dummyName",
                                                    setOf(
                                                            MediaResource(
                                                                    AspectRatio(1.5, "dummyActual", "dummyClosest"),
                                                                    1,
                                                                    2,
                                                                    "application/dummyType",
                                                                    "dummyResize",
                                                                    3,
                                                                    "dummyUrl"
                                                            )
                                                    )
                                            )
                                    ),
                                    true,
                                    Album(
                                            "dummyAccountEntityId",
                                            "dummyEntityId",
                                            "dummyId",
                                            "dummyLink",
                                            "dummyName",
                                            "dummyType",
                                            listOf(
                                                    Artist(
                                                            "dummyAccountEntityId",
                                                            "dummyEntityId",
                                                            "dummyId",
                                                            "dummyName",
                                                            setOf(
                                                                    MediaResource(
                                                                            AspectRatio(1.5, "dummyActual", "dummyClosest"),
                                                                            1,
                                                                            2,
                                                                            "application/dummyType",
                                                                            "dummyResize",
                                                                            3,
                                                                            "dummyUrl"
                                                                    )
                                                            )
                                                    )
                                            ),
                                            setOf(
                                                    MediaResource(
                                                            AspectRatio(1.5, "dummyActual", "dummyClosest"),
                                                            1,
                                                            2,
                                                            "application/dummyType",
                                                            "dummyResize",
                                                            3,
                                                            "dummyUrl"
                                                    )
                                            ),
                                            1,
                                            2,
                                            listOf("dummyGenre1", "dummyGenre2"),
                                            emptyList()
                                    ),
                                    4
                            ),
                            """
                                {
                                    "accountentityid":"dummyaccountentityid",
                                    "entityid":"dummyentityid",
                                    "id":"dummyid",
                                    "name":"dummyname",
                                    "duration":1,
                                    "discnumber":2,
                                    "number":3,
                                    "link":"dummylink",
                                    "artists":[
                                        {
                                            "accountentityid":"dummyAccountEntityId",
                                            "entityid":"dummyEntityId",
                                            "id":"dummyId",
                                            "name":"dummyName",
                                            "resources":[
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
                                            ]
                                        }
                                    ],
                                    "explicit":true,
                                    "album":{
                                        "accountentityid":"dummyAccountEntityId",
                                        "entityid":"dummyEntityId",
                                        "id":"dummyId",
                                        "link":"dummyLink",
                                        "name":"dummyName",
                                        "type":"dummyType",
                                        "artists":[
                                            {
                                                "accountentityid":"dummyAccountEntityId",
                                                "entityid":"dummyEntityId",
                                                "id":"dummyId",
                                                "name":"dummyName",
                                                "resources":[
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
                                                ]
                                            }
                                        ],
                                        "resources":[
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
                                        ],
                                        "releasedate":1,
                                        "popularity":2,
                                        "genres":["dummyGenre1","dummyGenre2"],
                                        "tracks":[]
                                    },
                                    "popularity":4
                                }
                            """.trimIndent() //TODO Album
                    )
            )

    override val jsonTests: List<Pair<Track?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
}) {
    @Test
    fun `when album is null, isSimplifiedTrack should be true`() {
        Assert.assertTrue(modelParam.emptyTest!!.copy(album = null).isSimplifiedTrack)
    }

    @Test
    fun `when album is not null, isSimplifiedTrack should be false`() {
        val album = Album(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        )
        Assert.assertFalse(modelParam.emptyTest!!.copy(album = album).isSimplifiedTrack)
    }
}