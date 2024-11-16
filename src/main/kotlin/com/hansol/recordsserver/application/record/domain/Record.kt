package com.hansol.recordsserver.application.record.domain

import com.hansol.recordsserver.common.vo.Image
import java.time.LocalDateTime

class Record(
    val id: Long,
    val name: String,
    val releaseDate: LocalDateTime,
    val tags: List<String>,
    val image: Image,
) {
}