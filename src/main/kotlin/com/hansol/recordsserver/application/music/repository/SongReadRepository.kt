package com.hansol.recordsserver.application.music.repository

import com.hansol.recordsserver.application.music.domain.Songs
import org.springframework.stereotype.Repository

@Repository
interface SongReadRepository {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): Songs
}