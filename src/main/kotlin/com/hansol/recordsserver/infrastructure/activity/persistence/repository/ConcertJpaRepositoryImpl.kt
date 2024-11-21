package com.hansol.recordsserver.infrastructure.activity.persistence.repository

import com.hansol.recordsserver.infrastructure.activity.persistence.entity.ConcertArtistJpaEntity
import com.hansol.recordsserver.infrastructure.activity.persistence.entity.QConcertArtistJpaEntity.concertArtistJpaEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ConcertJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : ConcertJpaRepositoryCustom {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): List<ConcertArtistJpaEntity> {
        return jpaQueryFactory.selectFrom(concertArtistJpaEntity)
            .where(
                concertArtistJpaEntity.artist.id.eq(artistId),
                cursor?.let { concertArtistJpaEntity.id.lt(cursor) },
            )
            .orderBy(concertArtistJpaEntity.id.desc())
            .limit(limit)
            .fetch()
    }
}