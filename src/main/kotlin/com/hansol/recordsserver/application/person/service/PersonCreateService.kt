package com.hansol.recordsserver.application.person.service

import com.hansol.recordsserver.application.person.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonCreateService(
    val personRepository: PersonRepository,
) {

    fun create() {
    }
}