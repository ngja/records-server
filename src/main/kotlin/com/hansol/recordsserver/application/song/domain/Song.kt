package com.hansol.recordsserver.application.song.domain

import com.hansol.recordsserver.application.record.domain.Record
import java.time.LocalDateTime

class Song(
    val id: Long,
    val record: Record,
    val title: String,
    val lyrics: String,
    val composition: String,
    val arrangement: String,
    val releaseDate: LocalDateTime,
) {
}