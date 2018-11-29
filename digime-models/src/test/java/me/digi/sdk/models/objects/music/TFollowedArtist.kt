package me.digi.sdk.models.objects.music

import me.digi.sdk.models.music.FollowedArtist
import me.digi.sdk.models.objects.ModelTestObject
import me.digi.sdk.models.objects.TMediaResource

object TFollowedArtist : ModelTestObject<FollowedArtist>(
        FollowedArtist(
                "dummyAccountEntityId",
                "dummyEntityId",
                "dummyId",
                "dummyName",
                setOf(
                        TMediaResource.obj
                )
        ),
        """
        {
            "accountentityid":"dummyAccountEntityId",
            "entityid":"dummyEntityId",
            "id":"dummyId",
            "name":"dummyName",
            "resources":[
                ${TMediaResource.json}
            ]
        }
        """.trimIndent()
)