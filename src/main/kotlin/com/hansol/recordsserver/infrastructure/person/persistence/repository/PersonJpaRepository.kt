package com.hansol.recordsserver.infrastructure.person.persistence.repository

import com.hansol.recordsserver.infrastructure.person.persistence.entity.PersonJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonJpaRepository : JpaRepository<PersonJpaEntity, Long> {
}