package com.hansol.recordsserver.presentation.person.dto.request

import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.common.enums.Gender
import com.hansol.recordsserver.common.utils.DateTimeParser

data class PersonCreateRequest(
    val surname: String,
    val forename: String,
    val name: String? = null,
    val gender: String,
    val birthday: String,
    val height: Int,
    val nationalityIds: List<Long>,
    val educations: List<String>,
) {
    fun toCommand(): PersonCreateCommand {
        return PersonCreateCommand(
            surname = surname,
            forename = forename,
            name = name ?: (surname + forename),
            gender = Gender.from(gender),
            birthday = DateTimeParser.toDate(birthday).atStartOfDay(),
            height = height,
            nationalityIds = nationalityIds,
            educations = educations,
        )
    }
}
