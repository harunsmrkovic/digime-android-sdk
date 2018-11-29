/*
 * Copyright (c) 2009-2018 digi.me Limited. All rights reserved.
 */

package me.digi.sdk.models.music

import me.digi.sdk.models.ModelTest
import me.digi.sdk.models.objects.music.TPlaylistTrack

class PlaylistTrackSpec : ModelTest<PlaylistTrack>(PlaylistTrack::class.java) {
    override val emptyTest: PlaylistTrack? = PlaylistTrack(
            null,
            null,
            null,
            null,
            null,
            null
    )

    override val jsonObjectTests: List<Pair<PlaylistTrack?, String>> =
            listOf(
                    Pair(
                            TPlaylistTrack.obj,
                            TPlaylistTrack.json
                    )
            )
}