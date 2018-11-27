package me.digi.sdk.models.music

import me.digi.sdk.models.AspectRatio
import me.digi.sdk.models.MediaResource
import me.digi.sdk.models.ModelParam
import me.digi.sdk.models.ModelTest

class ActorSpec : ModelTest<Actor>(Actor::class.java, object : ModelParam<Actor> {
    override val emptyTest: Actor? = Actor(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Actor?, String>> =
            listOf(
                    Pair(
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
                                            ),
                                            MediaResource(
                                                    AspectRatio(2.5, "dummyActual", "dummyClosest"),
                                                    4,
                                                    5,
                                                    "application/dummyType",
                                                    "dummyResize",
                                                    6,
                                                    "dummyUrl"
                                            )
                                    )
                            ),
                            """
                                {
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
                                        },
                                        {
                                            "aspectratio":{
                                                "accuracy":2.5,
                                                "actual":"dummyActual",
                                                "closest":"dummyClosest"
                                            },
                                            "height":4,
                                            "width":5,
                                            "mimetype":"application/dummyType",
                                            "resize":"dummyResize",
                                            "type":6,
                                            "url":"dummyUrl"
                                        }
                                    ]
                                }
                            """.trimIndent()
                    ),
                    Pair(
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
                            """
                                {
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
                                }
                            """.trimIndent()
                    ),
                    Pair(
                            Actor(
                                    "dummyAccountEntityId",
                                    "dummyEntityId",
                                    "dummyId",
                                    "dummyLink",
                                    "dummyName",
                                    emptySet()
                            ),
                            """
                                {
                                    "accountentityid":"dummyAccountEntityId",
                                    "entityid":"dummyEntityId",
                                    "id":"dummyId",
                                    "link":"dummyLink",
                                    "name":"dummyName",
                                    "resources":[]
                                }
                            """.trimIndent()
                    )
            )

    override val jsonTests: List<Pair<Actor?, String>> =
            listOf(
                    Pair(
                            emptyTest,
                            """{"dummyType": "dummy"}"""
                    )
            )
})