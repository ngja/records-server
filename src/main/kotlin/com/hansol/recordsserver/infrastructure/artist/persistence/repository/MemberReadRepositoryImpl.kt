package com.hansol.recordsserver.infrastructure.artist.persistence.repository

import com.hansol.recordsserver.application.artist.domain.Members
import com.hansol.recordsserver.application.artist.repository.MemberReadRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
class MemberReadRepositoryImpl(
    private val memberJpaRepository: MemberJpaRepository,
) : MemberReadRepository {
    override fun findByArtistId(artistId: Long): Members {
        val memberJpaEntities = memberJpaRepository.findAllByArtistId(artistId)
        return Members(memberJpaEntities.map { it.toMember() })
    }
}