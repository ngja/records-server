package com.hansol.recordsserver.presentation.person.dto.response

import com.hansol.recordsserver.application.person.domain.PersonSearchDomain
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.common.dto.Cursored

data class PersonSearchResponse(
    val id: String,
    val name: String,
    val gender: String,
    val birthday: String,
    val height: Int,
) : Cursored {
    override fun cursor(): String = id

    companion object {
        fun from(personSearchDomain: PersonSearchDomain): PersonSearchResponse {
            return PersonSearchResponse(
                id = IdUtils.encode(personSearchDomain.id),
                name = personSearchDomain.name,
                gender = personSearchDomain.gender.label,
                birthday = DateTimeParser.toString(personSearchDomain.birthday.toLocalDate()),
                height = personSearchDomain.height,
            )
        }
    }
}
