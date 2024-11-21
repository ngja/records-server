package com.hansol.recordsserver.infrastructure.activity.persistence.entity

import com.hansol.recordsserver.infrastructure.artist.persistence.entity.ArtistJpaEntity
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "concert_artist")
@SQLRestriction("deleted = false")
class ConcertArtistJpaEntity(
    @Id
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "artist_id")
    val artist: ArtistJpaEntity,

    @ManyToOne
    @JoinColumn(name = "concert_id")
    val concert: ConcertJpaEntity,
) : AuditBaseEntity() {
}