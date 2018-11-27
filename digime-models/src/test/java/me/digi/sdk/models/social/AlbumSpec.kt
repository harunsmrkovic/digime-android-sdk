package me.digi.sdk.models.social

import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class AlbumSpec : ModelTest<Album>(Album::class.java, object : ModelParam<Album> {
    override val emptyTest: Album? = Album(
            null,
            null,
            null,
            null,
            null,
            null,
            0,
            null,
            null,
            null,
            0,
            0,
            null,
            null,
            null,
            0,
            0,
            0
    )

    override val jsonObjectTests: List<Pair<Album?, String>> =
            listOf(
                    Pair(
                            Album(
                                    "dummyBaseId",
                                    "dummyEntityId",
                                    "dummyMediaAlbumId",
                                    "dummySocialNetworkUserEntityId",
                                    "dummyMediaAlbumObjectId",
                                    "dummyReferenceEntityId",
                                    1,
                                    "dummyMediaEntityId",
                                    "dummyName",
                                    "dummyDescription",
                                    2,
                                    3,
                                    "dummyLink",
                                    "dummyLocation",
                                    "dummyLocationEntityId",
                                    4,
                                    5,
                                    6
                            ),
                            """
                                {
                                   "baseid":"dummyBaseId",
                                   "entityid":"dummyEntityId",
                                   "mediaalbumid":"dummyMediaAlbumId",
                                   "socialnetworkuserentityid":"dummySocialNetworkUserEntityId",
                                   "mediaalbumobjectid":"dummyMediaAlbumObjectId",
                                   "referenceentityid":"dummyReferenceEntityId",
                                   "referenceentitytype":1,
                                   "mediaentityid":"dummyMediaEntityId",
                                   "name":"dummyName",
                                   "description":"dummyDescription",
                                   "createddate":2,
                                   "itemcount":3,
                                   "link":"dummyLink",
                                   "location":"dummyLocation",
                                   "locationentityid":"dummyLocationEntityId",
                                   "updateddate":4,
                                   "updateddatemajor":5,
                                   "type":6
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Album?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})