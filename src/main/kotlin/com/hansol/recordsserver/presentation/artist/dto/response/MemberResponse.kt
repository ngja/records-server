package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.artist.domain.Member
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.common.vo.Image

data class MemberResponse(
    val id: String,
    val name: String,
    val image: Image,
) {
    constructor(member: Member) : this(
        id = IdUtils.encode(member.id),
        name = member.name,
        image = member.image,
    )
}
