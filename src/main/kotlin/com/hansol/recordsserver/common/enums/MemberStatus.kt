package com.hansol.recordsserver.common.enums

enum class MemberStatus(
    val label: String,
) {
    ACTIVE("활동"),
    ON_HIATUS("휴식"),
    LEAVE("탈퇴"),
    DISBANDED("해체"),
}