package com.hansol.recordsserver.application.person.repository

import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.application.person.domain.Person

interface PersonRepository {
    fun create(personCreateCommand: PersonCreateCommand): Person
}