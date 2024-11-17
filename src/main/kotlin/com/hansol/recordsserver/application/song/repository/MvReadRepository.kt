package com.hansol.recordsserver.application.song.repository

import com.hansol.recordsserver.application.song.domain.Mvs
import org.springframework.stereotype.Repository

@Repository
interface MvReadRepository {
    fun findByArtistIdLimit(artistId: Long, limit: Long): Mvs
}