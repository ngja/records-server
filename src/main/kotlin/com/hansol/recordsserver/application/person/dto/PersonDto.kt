package com.hansol.recordsserver.application.person.dto

import com.hansol.recordsserver.common.enums.Gender
import java.time.LocalDateTime

data class PersonDto(
    val id: Long,
    val surname: String,
    val forename: String,
    val name: String,
    val gender: Gender,
    val birthday: LocalDateTime,
    val height: Int,
)
