package com.hansol.recordsserver.application.artist.repository

import com.hansol.recordsserver.application.artist.domain.Members
import org.springframework.stereotype.Repository

@Repository
interface MemberReadRepository {
    fun findByArtistId(artistId: Long): Members
}