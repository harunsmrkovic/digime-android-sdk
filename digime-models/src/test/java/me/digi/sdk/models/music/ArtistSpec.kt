package me.digi.sdk.models.music

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.music.TArtist
import me.digi.sdk.models.objects.music.TFollowedArtist

class ArtistSpec : ModelTest<Artist>(Artist::class.java) {
    override val emptyTest: Artist? = Artist(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<Artist?, String>> =
            listOf(
                    Pair(
                            TArtist.obj,
                            TArtist.json
                    )
            )
}

class FollowedArtistSpec : ModelTest<FollowedArtist>(FollowedArtist::class.java) {
    override val emptyTest: FollowedArtist? = FollowedArtist(
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<FollowedArtist?, String>> =
            listOf(
                    Pair(
                            TFollowedArtist.obj,
                            TFollowedArtist.json
                    )
            )
}