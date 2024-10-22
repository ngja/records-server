package com.hansol.recordsserver.presentation.person.dto.response

import com.hansol.recordsserver.application.person.domain.Person
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
        fun from(person: Person): PersonCreateResponse {
            return PersonCreateResponse(
                id = IdGenerator.encode(person.id),
                surname = person.surname,
                forename = person.forename,
                name = person.name,
                gender = person.gender.label,
                birthday = DateTimeParser.toString(person.birthday),
                height = person.height,
            )
        }
    }
}