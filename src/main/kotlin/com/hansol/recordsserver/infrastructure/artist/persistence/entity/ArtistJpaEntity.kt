package com.hansol.recordsserver.infrastructure.artist.persistence.entity

import com.hansol.recordsserver.application.artist.domain.Artist
import com.hansol.recordsserver.common.enums.ArtistStatus
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import com.hansol.recordsserver.infrastructure.common.persistence.entity.ImageJpaEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDateTime

@Entity
@Table(name = "artist")
@SQLRestriction("deleted = false")
class ArtistJpaEntity(

    @Id
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val debutDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: ArtistStatus,

    @Embedded
    val image: ImageJpaEntity,
) : AuditBaseEntity() {

    fun toArtist(): Artist {
        return Artist(
            id = id,
            name = name,
            description = description,
            debutDate = debutDate,
            status = status,
            mainImage = image.toImage()
        )
    }
}