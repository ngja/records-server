package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.artist.domain.Member
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.common.dto.ImageResponse

data class ArtistDetailMemberResponse(
    val id: String,
    val name: String,
    val image: ImageResponse,
) {
    constructor(member: Member) : this(
        id = IdUtils.encode(member.id),
        name = member.name,
        image = ImageResponse(member.image),
    )
}
