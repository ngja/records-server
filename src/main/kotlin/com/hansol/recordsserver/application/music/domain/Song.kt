package com.hansol.recordsserver.application.music.domain

import java.time.LocalDateTime

class Song(
    val id: Long,
    val album: Album,
    val track: Int,
    val title: String,
    val lyrics: String,
    val composition: String,
    val arrangement: String,
) {

    fun getReleaseDate(): LocalDateTime {
        return album.releaseDate
    }
}