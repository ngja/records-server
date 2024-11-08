package com.hansol.recordsserver.application.person.domain

import com.hansol.recordsserver.application.country.domain.Country
import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.common.enums.Gender
import com.hansol.recordsserver.common.utils.IdGenerator
import java.time.LocalDateTime

class Person(
    val id: Long,
    val surname: String,
    val forename: String,
    val name: String,
    val gender: Gender,
    val birthday: LocalDateTime,
    val height: Int,
    val nationalities: List<Country>
) {

    constructor(command: PersonCreateCommand, nationalities: List<Country>) : this(
        id = IdGenerator.generate(),
        surname = command.surname,
        forename = command.forename,
        name = command.name,
        gender = command.gender,
        birthday = command.birthday,
        height = command.height,
        nationalities = nationalities
    )
}
