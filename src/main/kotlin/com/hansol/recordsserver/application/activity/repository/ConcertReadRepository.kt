package com.hansol.recordsserver.application.activity.repository

import com.hansol.recordsserver.application.activity.domain.Concerts
import org.springframework.stereotype.Repository

@Repository
interface ConcertReadRepository {
    fun findByArtistId(artistId: Long, limit: Long, cursor: Long? = null): Concerts
}