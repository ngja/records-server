package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.AlbumJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AlbumJpaRepository : JpaRepository<AlbumJpaEntity, Long>, AlbumJpaRepositoryCustom {
}