package com.hansol.recordsserver.application.person.repository

import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.application.person.dto.PersonDto

interface PersonRepository {
    fun create(personCreateCommand: PersonCreateCommand): PersonDto
}