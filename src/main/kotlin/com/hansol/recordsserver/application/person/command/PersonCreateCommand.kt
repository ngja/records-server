package com.hansol.recordsserver.application.person.command

import com.hansol.recordsserver.application.person.validator.PersonFieldValidator
import com.hansol.recordsserver.common.enums.Gender
import java.time.LocalDateTime

data class PersonCreateCommand(
    val surname: String,
    val forename: String,
    val name: String,
    val gender: Gender,
    val birthday: LocalDateTime,
    val height: Int,
    val nationalityIds: List<Long>,
    val educations: List<String>,
) {
    init {
        PersonFieldValidator.validateSurname(surname)
        PersonFieldValidator.validateForename(forename)
    }
}
