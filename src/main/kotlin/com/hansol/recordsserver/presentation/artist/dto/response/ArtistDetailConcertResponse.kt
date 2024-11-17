package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.activity.domain.Concert
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.common.dto.ImageResponse

data class ArtistDetailConcertResponse(
    val id: String,
    val name: String,
    val type: String,
    val startDate: String,
    val endDate: String,
    val image: ImageResponse,
) {
    constructor(concert: Concert) : this(
        id = IdUtils.encode(concert.id),
        name = concert.name,
        type = concert.type.label,
        startDate = DateTimeParser.toString(concert.startDate.toLocalDate()),
        endDate = DateTimeParser.toString(concert.endDate.toLocalDate()),
        image = ImageResponse(concert.image),
    )
}