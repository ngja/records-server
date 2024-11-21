package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.MvJpaEntity
import com.hansol.recordsserver.infrastructure.music.persistence.entity.QMvJpaEntity.mvJpaEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MvJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : MvJpaRepositoryCustom {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): List<MvJpaEntity> {
        return jpaQueryFactory.selectFrom(mvJpaEntity)
            .where(
                mvJpaEntity.artist.id.eq(artistId),
                cursor?.let { mvJpaEntity.id.lt(it) }
            )
            .orderBy(mvJpaEntity.id.desc())
            .limit(limit)
            .fetch()
    }
}