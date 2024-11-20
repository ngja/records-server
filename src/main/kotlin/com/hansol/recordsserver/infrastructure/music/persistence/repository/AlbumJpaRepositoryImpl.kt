package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.AlbumJpaEntity
import com.hansol.recordsserver.infrastructure.music.persistence.entity.QAlbumJpaEntity.albumJpaEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class AlbumJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : AlbumJpaRepositoryCustom {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): List<AlbumJpaEntity> {
        return jpaQueryFactory.selectFrom(albumJpaEntity)
            .where(
                cursor?.let { albumJpaEntity.artistId.lt(cursor) }
            )
            .limit(limit)
            .orderBy(albumJpaEntity.id.desc())
            .fetch()
    }
}