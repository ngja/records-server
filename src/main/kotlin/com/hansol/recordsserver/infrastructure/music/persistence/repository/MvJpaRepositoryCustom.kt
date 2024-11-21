package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.MvJpaEntity

interface MvJpaRepositoryCustom {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): List<MvJpaEntity>
}