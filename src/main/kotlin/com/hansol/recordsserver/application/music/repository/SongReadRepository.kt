package com.hansol.recordsserver.application.music.repository

import com.hansol.recordsserver.application.music.domain.Songs
import org.springframework.stereotype.Repository

@Repository
interface SongReadRepository {
    fun findByArtistIdLimit(artistId: Long, limit: Long): Songs
}