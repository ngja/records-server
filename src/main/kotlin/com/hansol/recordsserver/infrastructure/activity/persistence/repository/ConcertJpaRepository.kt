package com.hansol.recordsserver.infrastructure.activity.persistence.repository

import com.hansol.recordsserver.infrastructure.activity.persistence.entity.ConcertJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ConcertJpaRepository : JpaRepository<ConcertJpaEntity, Long>, ConcertJpaRepositoryCustom {
}