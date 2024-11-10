package com.hansol.recordsserver.infrastructure.person.persistence.repository

import com.hansol.recordsserver.application.person.command.PersonSearchCommand
import com.hansol.recordsserver.application.person.domain.PersonSearchDomain
import com.hansol.recordsserver.application.person.repository.PersonReadRepository
import org.springframework.stereotype.Repository

@Repository
class PersonReadRepositoryImpl(
    private val personJpaRepository: PersonJpaRepository,
) : PersonReadRepository {
    override fun search(command: PersonSearchCommand): List<PersonSearchDomain> {
        val personJpaEntities = personJpaRepository.search(command)
        return personJpaEntities.map { PersonSearchDomain(
            id = it.id,
            name = it.name,
            gender = it.gender,
            birthday = it.birthday,
            height = it.height,
        ) }
    }
}