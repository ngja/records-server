package com.hansol.recordsserver.application.activity.repository

import com.hansol.recordsserver.application.activity.domain.Concerts
import org.springframework.stereotype.Repository

@Repository
interface ConcertReadRepository {
    fun findByArtistIdLimit(artistId: Long, limit: Long): Concerts
}