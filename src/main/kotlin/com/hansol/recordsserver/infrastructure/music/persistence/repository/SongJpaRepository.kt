package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.SongJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SongJpaRepository : JpaRepository<SongJpaEntity, Long>, SongJpaRepositoryCustom {
}