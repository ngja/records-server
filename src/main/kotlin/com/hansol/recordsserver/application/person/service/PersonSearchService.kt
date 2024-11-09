package com.hansol.recordsserver.application.person.service

import com.hansol.recordsserver.application.person.command.PersonSearchCommand
import com.hansol.recordsserver.application.person.domain.PersonSearchDomain
import com.hansol.recordsserver.application.person.repository.PersonReadRepository
import org.springframework.stereotype.Service

@Service
class PersonSearchService(
    private val personReadRepository: PersonReadRepository,
) {
    fun search(command: PersonSearchCommand): List<PersonSearchDomain> {
        return personReadRepository.search(command)
    }
}