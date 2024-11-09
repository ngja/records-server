package com.hansol.recordsserver.infrastructure.person.persistence.entity

import com.hansol.recordsserver.application.person.domain.Person
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "person_nationality")
@SQLRestriction("deleted = false")
class PersonNationalityJpaEntity(
    @Id
    val id: Long,

    @Column(nullable = false)
    val personId: Long,

    @Column(nullable = false)
    val countryId: Long,

    @Column(nullable = false)
    val nameByCountry: Long?,

) : AuditBaseEntity() {

    companion object {
        fun from(person: Person): List<PersonNationalityJpaEntity> {
            return person.nationalities.map {
                PersonNationalityJpaEntity(
                    id = IdUtils.generate(),
                    personId = person.id,
                    countryId = it.id,
                    nameByCountry = null,
                )
            }
        }
    }
}