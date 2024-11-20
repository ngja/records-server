package com.hansol.recordsserver.application.music.domain

import java.time.LocalDateTime

class Song(
    val id: Long,
    val album: Album,
    val title: String,
    val lyrics: String,
    val composition: String,
    val arrangement: String,
    val releaseDate: LocalDateTime,
) {
}