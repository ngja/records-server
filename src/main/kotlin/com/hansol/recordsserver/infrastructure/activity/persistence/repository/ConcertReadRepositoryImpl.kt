package com.hansol.recordsserver.infrastructure.activity.persistence.repository

import com.hansol.recordsserver.application.activity.domain.Concerts
import com.hansol.recordsserver.application.activity.repository.ConcertReadRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
class ConcertReadRepositoryImpl(
    private val concertJpaRepository: ConcertJpaRepository,
) : ConcertReadRepository {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): Concerts {
        val jpaEntities = concertJpaRepository.findByArtistId(artistId, limit, cursor)
        val concerts = jpaEntities.map { it.concert.toConcert() }
        return Concerts(concerts)
    }
}