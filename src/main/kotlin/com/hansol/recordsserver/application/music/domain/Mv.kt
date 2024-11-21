package com.hansol.recordsserver.application.music.domain

import com.hansol.recordsserver.application.artist.domain.Artist

class Mv(
    val id: Long,
    val artist: Artist,
    val song: Song,
    val url: String,
) {
}