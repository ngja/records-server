package com.hansol.recordsserver.application.person.repository

import com.hansol.recordsserver.application.person.domain.Person

interface PersonWriteRepository {
    fun create(person: Person): Person
}