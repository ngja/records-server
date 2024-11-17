package com.hansol.recordsserver.application.activity.domain

import com.hansol.recordsserver.common.enums.ConcertType
import com.hansol.recordsserver.common.vo.Image
import java.time.LocalDateTime

class Concert(
    val id: Long,
    val name: String,
    val type: ConcertType,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val image: Image,
) {
}