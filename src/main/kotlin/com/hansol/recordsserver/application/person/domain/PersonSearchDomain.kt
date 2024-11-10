package com.hansol.recordsserver.application.person.domain

import com.hansol.recordsserver.common.enums.Gender
import java.time.LocalDateTime

class PersonSearchDomain(
    val id: Long,
    val name: String,
    val gender: Gender,
    val birthday: LocalDateTime,
    val height: Int,
) {

}