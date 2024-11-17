package com.hansol.recordsserver.application.song.repository

import com.hansol.recordsserver.application.song.domain.Songs
import org.springframework.stereotype.Repository

@Repository
interface SongReadRepository {
    fun findByArtistIdLimit(artistId: Long, limit: Long): Songs
}