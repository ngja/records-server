package com.hansol.recordsserver.infrastructure.artist.persistence.repository

import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.application.artist.domain.Artist
import com.hansol.recordsserver.application.artist.repository.ArtistReadRepository
import org.springframework.stereotype.Repository

@Repository
class ArtistReadRepositoryImpl(
    private val artistJpaRepository: ArtistJpaRepository,
) : ArtistReadRepository {
    override fun search(artistSearchCommand: ArtistSearchCommand): List<Artist> {
        val artistJpaEntities = artistJpaRepository.search(artistSearchCommand)
        return artistJpaEntities.map { it.toArtist() }
    }

    override fun findById(artistId: Long): Artist {
        return artistJpaRepository.findById(artistId)
            .orElseThrow { NoSuchElementException("Artist with id $artistId not found") }
            .toArtist()
    }
}