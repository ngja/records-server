package com.hansol.recordsserver.infrastructure.activity.persistence.repository

import com.hansol.recordsserver.infrastructure.activity.persistence.entity.ConcertArtistJpaEntity

interface ConcertJpaRepositoryCustom {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): List<ConcertArtistJpaEntity>
}