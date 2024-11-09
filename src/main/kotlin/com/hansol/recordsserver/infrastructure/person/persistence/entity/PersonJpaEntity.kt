package com.hansol.recordsserver.infrastructure.person.persistence.entity

import com.hansol.recordsserver.application.person.domain.Person
import com.hansol.recordsserver.common.enums.Gender
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDateTime

@Entity
@Table(name = "person")
@SQLRestriction("deleted = false")
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
) : AuditBaseEntity() {

    companion object {
        fun from(person: Person): PersonJpaEntity {
            return PersonJpaEntity(
                id = IdUtils.generate(),
                surname = person.surname,
                forename = person.forename,
                name = person.name,
                gender = person.gender,
                birthday = person.birthday,
                height = person.height,
            )
        }
    }
}