package com.hansol.recordsserver.infrastructure.person.persistence.repository

import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.application.person.dto.PersonDto
import com.hansol.recordsserver.application.person.repository.PersonRepository
import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonJpaEntity
import org.springframework.stereotype.Repository

@Repository
class PersonRepositoryImpl(
    private val personJpaRepository: PersonJpaRepository
) : PersonRepository {
    override fun create(personCreateCommand: PersonCreateCommand): PersonDto {
        val personJpaEntity = PersonJpaEntity.from(personCreateCommand)
        val result = personJpaRepository.save(personJpaEntity)
        return result.toDto()
    }
}