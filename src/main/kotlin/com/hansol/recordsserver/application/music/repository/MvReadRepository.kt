package com.hansol.recordsserver.application.music.repository

import com.hansol.recordsserver.application.music.domain.Mvs
import org.springframework.stereotype.Repository

@Repository
interface MvReadRepository {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): Mvs
}