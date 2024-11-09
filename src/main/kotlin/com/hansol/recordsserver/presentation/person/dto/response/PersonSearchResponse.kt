package com.hansol.recordsserver.presentation.person.dto.response

import com.hansol.recordsserver.application.person.domain.PersonSearchDomain
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.common.dto.Cursored

data class PersonSearchResponse(
    val id: String,
) : Cursored {
    override fun cursor(): String = id

    companion object {
        fun from(personSearchDomain: PersonSearchDomain): PersonSearchResponse {
            return PersonSearchResponse(
                id = IdUtils.encode(personSearchDomain.id),
            )
        }
    }
}
