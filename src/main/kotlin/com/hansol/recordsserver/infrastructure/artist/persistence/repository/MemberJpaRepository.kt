package com.hansol.recordsserver.infrastructure.artist.persistence.repository

import com.hansol.recordsserver.infrastructure.artist.persistence.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberJpaRepository : JpaRepository<MemberJpaEntity, Long> {
    fun findAllByArtistId(artistId: Long): List<MemberJpaEntity>
}