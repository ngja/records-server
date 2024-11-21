package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.application.music.domain.Mvs
import com.hansol.recordsserver.application.music.repository.MvReadRepository
import org.springframework.stereotype.Repository

@Repository
class MvReadRepositoryImpl(
    private val mvJpaRepository: MvJpaRepository,
) : MvReadRepository {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): Mvs {
        val jpaEntities = mvJpaRepository.findByArtistId(artistId, limit, cursor)
        val mvs = jpaEntities.map { it.toMv() }
        return Mvs(mvs)
    }
}