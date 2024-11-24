package com.hansol.recordsserver.application.artist.domain

import com.hansol.recordsserver.common.enums.MemberStatus

class Members(
    val members: List<Member>,
) {

    fun getNotLeaveMembers(): List<Member> {
        return members.filter { MemberStatus.LEAVE != it.status }
    }
}