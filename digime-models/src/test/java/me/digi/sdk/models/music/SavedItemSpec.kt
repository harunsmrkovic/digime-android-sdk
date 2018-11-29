package me.digi.sdk.models.music

import me.digi.sdk.models.AspectRatio
import me.digi.sdk.models.MediaResource
import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class SavedAlbumSpec : ModelTest<SavedAlbum>(SavedAlbum::class.java, object : ModelParam<SavedAlbum> {
    override val emptyTest: SavedAlbum? = SavedAlbum(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SavedAlbum?, String>> =
            listOf(
                    Pair(
                            SavedAlbum(
                                    "dummyaccountentityid",
                                    "dummyentityid",
                                    1,
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
                                    )
                            ),
                            """
                                {
                                    "accountentityid":"dummyaccountentityid",
                                    "entityid":"dummyentityid",
                                    "createddate":1,
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
                                    }
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<SavedAlbum?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})

class SavedTrackSpec : ModelTest<SavedTrack>(SavedTrack::class.java, object : ModelParam<SavedTrack> {
    override val emptyTest: SavedTrack? = SavedTrack(
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<SavedTrack?, String>> =
            listOf(
                    Pair(
                            SavedTrack(
                                    "dummyaccountentityid",
                                    "dummyentityid",
                                    1,
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
                                    )
                            ),
                            """
                                {
                                    "accountentityid":"dummyaccountentityid",
                                    "entityid":"dummyentityid",
                                    "createddate":1,
                                    "track":{
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
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<SavedTrack?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})