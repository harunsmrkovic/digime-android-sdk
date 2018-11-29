package me.digi.sdk.models.health_and_fitness

import me.digi.sdk.models.AspectRatio
import me.digi.sdk.models.MediaResource

import me.digi.sdk.models.ModelTest

class BadgeSpec : ModelTest<Badge>(Badge::class.java) {
    override val emptyTest: Badge? = Badge(
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
            null,
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Badge?, String>> =
            listOf(
                    Pair(
                            Badge(
                                    "dummyId",
                                    "dummyEntityId",
                                    "dummyAccountEntityId",
                                    1,
                                    "dummyCategory",
                                    2,
                                    3,
                                    "dummyName",
                                    "dummyShortName",
                                    "dummyDescription",
                                    "dummyShortDescription",
                                    "dummyEarnedMessage",
                                    "dummyMarketingDescription",
                                    "dummymobileDescription",
                                    "dummyShareText",
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
                                    "dummyGradientEndColor",
                                    "dummyGradientStartColor"
                            ),
                            """
                                {
                                    "id":"dummyId",
                                    "entityid":"dummyEntityId",
                                    "accountentityid":"dummyAccountEntityId",
                                    "updateddate":1,
                                    "category":"dummyCategory",
                                    "timesachieved":2,
                                    "value":3,
                                    "name":"dummyName",
                                    "shortname":"dummyShortName",
                                    "description":"dummyDescription",
                                    "shortdescription":"dummyShortDescription",
                                    "earnedmessage":"dummyEarnedMessage",
                                    "marketingdescription":"dummyMarketingDescription",
                                    "mobiledescription":"dummymobileDescription",
                                    "sharetext":"dummyShareText",
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
                                    "gradientendcolor":"dummyGradientEndColor",
                                    "gradientstartcolor":"dummyGradientStartColor"
                                }
                            """.trimIndent()
                    )
            )
}