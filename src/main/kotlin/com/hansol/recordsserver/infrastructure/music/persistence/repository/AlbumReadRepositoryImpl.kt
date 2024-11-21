package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.application.music.domain.Albums
import com.hansol.recordsserver.application.music.repository.AlbumReadRepository
import org.springframework.stereotype.Repository

@Repository
class AlbumReadRepositoryImpl(
    private val albumJpaRepository: AlbumJpaRepository,
) : AlbumReadRepository {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): Albums {
        val entities = albumJpaRepository.findByArtistId(artistId, limit, cursor)
        return Albums(entities.map { it.toAlbum() })
    }
}