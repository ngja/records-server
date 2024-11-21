package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.MvJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MvJpaRepository : JpaRepository<MvJpaEntity, Long>, MvJpaRepositoryCustom {
}