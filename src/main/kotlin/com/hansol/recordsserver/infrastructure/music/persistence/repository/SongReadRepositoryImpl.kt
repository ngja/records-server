package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.application.music.domain.Songs
import com.hansol.recordsserver.application.music.repository.SongReadRepository
import org.springframework.stereotype.Repository

@Repository
class SongReadRepositoryImpl(
    private val songJpaRepository: SongJpaRepository,
) : SongReadRepository {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): Songs {
        val jpaEntities = songJpaRepository.findByArtistId(artistId, limit, cursor)
        val songs = jpaEntities.map { it.toSong() }
        return Songs(songs)
    }
}