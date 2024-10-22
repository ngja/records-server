package com.hansol.recordsserver.infrastructure.person.persistence.entity

import com.hansol.recordsserver.application.person.command.PersonCreateCommand
import com.hansol.recordsserver.application.person.domain.Person
import com.hansol.recordsserver.common.enums.Gender
import com.hansol.recordsserver.common.utils.IdGenerator
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "person")
class PersonJpaEntity(

    @Id
    val id: Long,

    @Column(nullable = false)
    val surname: String,

    @Column(nullable = false)
    val forename: String,

    @Column(nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val gender: Gender,

    @Column(nullable = false)
    val birthday: LocalDateTime,

    @Column(nullable = false)
    val height: Int,
) {

    fun toDto(): Person = Person(
        id = this.id,
        surname = this.surname,
        forename = this.forename,
        name = this.name,
        gender = this.gender,
        birthday = this.birthday,
        height = this.height
    )

    companion object {
        fun from(personCreateCommand: PersonCreateCommand): PersonJpaEntity {
            return PersonJpaEntity(
                id = IdGenerator.generate(),
                surname = personCreateCommand.surname,
                forename = personCreateCommand.forename,
                name = personCreateCommand.name,
                gender = personCreateCommand.gender,
                birthday = personCreateCommand.birthday,
                height = personCreateCommand.height,
            )
        }
    }
}