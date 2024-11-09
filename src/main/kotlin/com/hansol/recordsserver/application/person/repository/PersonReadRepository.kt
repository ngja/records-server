package com.hansol.recordsserver.application.person.repository

import com.hansol.recordsserver.application.person.command.PersonSearchCommand
import com.hansol.recordsserver.application.person.domain.PersonSearchDomain

interface PersonReadRepository {
    fun search(command: PersonSearchCommand): List<PersonSearchDomain>
}