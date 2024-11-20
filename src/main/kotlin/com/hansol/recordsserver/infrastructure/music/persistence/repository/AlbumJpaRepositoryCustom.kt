package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.AlbumJpaEntity

interface AlbumJpaRepositoryCustom {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): List<AlbumJpaEntity>
}