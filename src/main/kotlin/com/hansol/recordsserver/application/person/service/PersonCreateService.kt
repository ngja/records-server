package com.hansol.recordsserver.application.person.service

import com.hansol.recordsserver.application.country.repository.CountryReadRepository
import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.application.person.domain.Person
import com.hansol.recordsserver.application.person.repository.PersonWriteRepository
import org.springframework.stereotype.Service

@Service
class PersonCreateService(
    val personWriteRepository: PersonWriteRepository,
    val countryReadRepository: CountryReadRepository,
) {
    fun create(personCreateCommand: PersonCreateCommand): Person {
        val nationalities = countryReadRepository.findByIds(personCreateCommand.nationalityIds)
        val person = Person(personCreateCommand, nationalities)
        personWriteRepository.create(person)
        return person
    }
}