package com.hansol.recordsserver.application.artist.repository

import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.application.artist.domain.Artist
import org.springframework.stereotype.Repository

@Repository
interface ArtistReadRepository {
    fun search(artistSearchCommand: ArtistSearchCommand): List<Artist>
    fun findById(artistId: Long): Artist
}