package com.hansol.recordsserver.application.music.repository

import com.hansol.recordsserver.application.music.domain.Albums
import org.springframework.stereotype.Repository

@Repository
interface AlbumReadRepository {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): Albums
}