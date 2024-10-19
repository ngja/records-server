package com.hansol.recordsserver.common.enums

import com.hansol.recordsserver.common.exception.FailedToParseException

enum class Gender(
    val label: String,
) {
    MALE("남성"), FEMALE("여성"),
    ;

    companion object {
        fun from(label: String): Gender {
            return entries.firstOrNull { it.label == label }
                ?: throw FailedToParseException("성별 변환에 실패했습니다. 입력값=$label", label)
        }
    }
}