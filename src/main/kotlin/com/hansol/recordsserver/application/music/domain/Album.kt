package com.hansol.recordsserver.application.music.domain

import com.hansol.recordsserver.common.vo.Image
import java.time.LocalDateTime

class Album(
    val id: Long,
    val artistId: Long,
    val name: String,
    val releaseDate: LocalDateTime,
    val tags: List<String>,
    val image: Image,
) {
}