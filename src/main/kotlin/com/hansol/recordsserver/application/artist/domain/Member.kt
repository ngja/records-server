package com.hansol.recordsserver.application.artist.domain

import com.hansol.recordsserver.common.enums.MemberStatus
import com.hansol.recordsserver.common.vo.Image

class Member(
    val id: Long,
    val name: String,
    val status: MemberStatus,
    val image: Image,
) {

}