package com.hansol.recordsserver.infrastructure.person.persistence.repository

import com.hansol.recordsserver.application.person.domain.Person
import com.hansol.recordsserver.application.person.repository.PersonWriteRepository
import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonJpaEntity
import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonNationalityJpaEntity
import org.springframework.stereotype.Repository

@Repository
class PersonWriteRepositoryImpl(
    private val personJpaRepository: PersonJpaRepository,
    private val personNationalityJpaRepository: PersonNationalityJpaRepository,
) : PersonWriteRepository {
    override fun create(person: Person): Person {
        personJpaRepository.save(
            PersonJpaEntity.from(person)
        )
        personNationalityJpaRepository.saveAll(
            PersonNationalityJpaEntity.from(person)
        )
        return person
    }
}