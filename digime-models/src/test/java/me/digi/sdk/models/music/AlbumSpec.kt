package me.digi.sdk.models.music

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.music.TAlbum

class AlbumSpec : ModelTest<Album>(Album::class.java) {
    override val emptyTest: Album? = Album(
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

    override val jsonObjectTests: List<Pair<Album?, String>> =
            listOf(
                    Pair(
                            TAlbum.obj,
                            TAlbum.json
                    )
            )
}