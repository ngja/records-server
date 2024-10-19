package com.hansol.recordsserver.application.person.service

import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.application.person.dto.PersonDto
import com.hansol.recordsserver.application.person.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonCreateService(
    val personRepository: PersonRepository,
) {
    fun create(personCreateCommand: PersonCreateCommand): PersonDto {
        return personRepository.create(personCreateCommand)
    }
}