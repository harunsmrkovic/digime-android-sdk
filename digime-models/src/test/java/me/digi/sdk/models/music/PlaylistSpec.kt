package me.digi.sdk.models.music

import me.digi.sdk.models.AspectRatio
import me.digi.sdk.models.MediaResource

import me.digi.sdk.models.ModelTest

class PlaylistSpec : ModelTest<Playlist>(Playlist::class.java) {
    override val emptyTest: Playlist? = Playlist(
            null,
            null,
            null,
            null,
            null,
            null,
            false,
            false,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Playlist?, String>> =
            listOf(
                    Pair(
                            Playlist(
                                    "dummyEntityId",
                                    "dummyAccountEntityId",
                                    "dummyId",
                                    "dummyName",
                                    "dummyDescription",
                                    1,
                                    true,
                                    true,
                                    Actor(
                                            "dummyAccountEntityId",
                                            "dummyEntityId",
                                            "dummyId",
                                            "dummyLink",
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
                                    ),
                                    "dummyLink",
                                    listOf(
                                            PlaylistTrack(
                                                    "dummyAccountEntityId",
                                                    "dummyEntityId",
                                                    "dummyId",
                                                    1,
                                                    Actor(
                                                            "dummyAccountEntityId",
                                                            "dummyEntityId",
                                                            "dummyId",
                                                            "dummyLink",
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
                                                    ),
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
                                    )
                            ),
                            """
                                {
                                    "entityid":"dummyEntityId",
                                    "accountentityid":"dummyAccountEntityId",
                                    "id":"dummyId",
                                    "name":"dummyName",
                                    "description":"dummyDescription",
                                    "followerscount":1,
                                    "public":true,
                                    "collaborative":true,
                                    "owner":{
                                        "accountentityid":"dummyAccountEntityId",
                                        "entityid":"dummyEntityId",
                                        "id":"dummyId",
                                        "link":"dummyLink",
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
                                    },
                                    "link":"dummyLink",
                                    "tracks":[
                                        {
                                            "accountentityid":"dummyAccountEntityId",
                                            "entityid":"dummyEntityId",
                                            "id":"dummyId",
                                            "createddate":1,
                                            "addedby":{
                                                "accountentityid":"dummyAccountEntityId",
                                                "entityid":"dummyEntityId",
                                                "id":"dummyId",
                                                "link":"dummyLink",
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
                                            },
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
                                    ]
                                }
                            """.trimIndent()
                    )
            )
}