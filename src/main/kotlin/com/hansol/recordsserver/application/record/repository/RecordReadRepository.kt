package com.hansol.recordsserver.application.record.repository

import com.hansol.recordsserver.application.record.domain.Records
import org.springframework.stereotype.Repository

@Repository
interface RecordReadRepository {
    fun findByArtistIdLimit(artistId: Long, limit: Long): Records
}