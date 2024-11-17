package com.hansol.recordsserver.common.enums

enum class ConcertType(
    val label: String,
) {
    TOUR("투어"),
    CONCERT("콘서트"),
    FAN_CONCERT("팬콘서트"),
    FAN_MEETING("팬미팅"),
}