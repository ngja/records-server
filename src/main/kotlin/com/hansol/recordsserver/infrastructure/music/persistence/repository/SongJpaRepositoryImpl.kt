package com.hansol.recordsserver.infrastructure.music.persistence.repository

import com.hansol.recordsserver.infrastructure.music.persistence.entity.QSongJpaEntity.songJpaEntity
import com.hansol.recordsserver.infrastructure.music.persistence.entity.SongJpaEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class SongJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : SongJpaRepositoryCustom {
    override fun findByArtistId(artistId: Long, limit: Long, cursor: Long?): List<SongJpaEntity> {
        return jpaQueryFactory.selectFrom(songJpaEntity)
            .where(
                songJpaEntity.album.artistId.eq(artistId),
                cursor?.let { songJpaEntity.id.lt(cursor) }
            )
            .orderBy(songJpaEntity.id.desc())
            .limit(limit)
            .fetch()
    }
}