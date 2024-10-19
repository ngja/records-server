package com.hansol.recordsserver.presentation.person.dto.response

import com.hansol.recordsserver.application.person.dto.PersonDto
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.utils.IdGenerator

data class PersonCreateResponse(
    val id: String,
    val surname: String,
    val forename: String,
    val name: String,
    val gender: String,
    val birthday: String,
    val height: Int,
) {

    companion object {
        fun from(personDto: PersonDto): PersonCreateResponse {
            return PersonCreateResponse(
                id = IdGenerator.encode(personDto.id),
                surname = personDto.surname,
                forename = personDto.forename,
                name = personDto.name,
                gender = personDto.gender.label,
                birthday = DateTimeParser.toString(personDto.birthday),
                height = personDto.height,
            )
        }
    }
}