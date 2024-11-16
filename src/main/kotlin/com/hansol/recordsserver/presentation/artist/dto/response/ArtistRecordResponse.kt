package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.record.domain.Record
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.common.dto.ImageResponse

data class ArtistRecordResponse(
    val id: String,
    val name: String,
    val releaseDate: String,
    val tags: List<String>,
    val image: ImageResponse,
) {
    constructor(record: Record) : this(
        id = IdUtils.encode(record.id),
        name = record.name,
        releaseDate = DateTimeParser.toString(record.releaseDate.toLocalDate()),
        tags = record.tags,
        image = ImageResponse(record.image),
    )
}