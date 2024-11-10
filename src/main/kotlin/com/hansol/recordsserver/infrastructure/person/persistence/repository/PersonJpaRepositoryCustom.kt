package com.hansol.recordsserver.infrastructure.person.persistence.repository

import com.hansol.recordsserver.application.person.command.PersonSearchCommand
import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonJpaEntity

interface PersonJpaRepositoryCustom {
    fun search(command: PersonSearchCommand): List<PersonJpaEntity>
}