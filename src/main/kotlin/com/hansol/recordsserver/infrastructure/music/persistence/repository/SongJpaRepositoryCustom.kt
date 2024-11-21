package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.SongJpaEntity

interface SongJpaRepositoryCustom {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): List<SongJpaEntity>
}