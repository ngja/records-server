package com.hansol.recordsserver.infrastructure.person.persistence.repository

import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonNationalityJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PersonNationalityJpaRepository : JpaRepository<PersonNationalityJpaEntity, Long> {
}