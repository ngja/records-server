package com.hansol.recordsserver.infrastructure.artist.persistence.repository

import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.infrastructure.artist.persistence.entity.ArtistJpaEntity
import com.hansol.recordsserver.infrastructure.artist.persistence.entity.QArtistJpaEntity.artistJpaEntity
import com.hansol.recordsserver.infrastructure.person.persistence.entity.QPersonJpaEntity.personJpaEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ArtistJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : ArtistJpaRepositoryCustom {
    override fun search(command: ArtistSearchCommand): List<ArtistJpaEntity> {
        return jpaQueryFactory.selectFrom(artistJpaEntity)
            .where(
                if (command.cursor != null) personJpaEntity.id.lt(command.cursor) else null
            )
            .orderBy(artistJpaEntity.id.desc())
            .limit(command.size)
            .fetch()
    }
}