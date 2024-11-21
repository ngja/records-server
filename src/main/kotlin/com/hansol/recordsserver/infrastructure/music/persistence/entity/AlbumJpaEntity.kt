package com.hansol.recordsserver.infrastructure.music.persistence.entity

import com.hansol.recordsserver.application.music.domain.Album
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import com.hansol.recordsserver.infrastructure.common.persistence.entity.ImageJpaEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDateTime

@Entity
@Table(name = "album")
@SQLRestriction("deleted = false")
class AlbumJpaEntity(
    @Id
    val id: Long,

    @Column(nullable = false)
    val artistId: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val releaseDate: LocalDateTime,

    @Column
    val tags: String,

    @Embedded
    val image: ImageJpaEntity,
) : AuditBaseEntity() {

    companion object {
        fun from(album: Album): AlbumJpaEntity {
            return AlbumJpaEntity(
                id = album.id,
                artistId = album.artistId,
                name = album.name,
                releaseDate = album.releaseDate,
                tags = album.tags.joinToString(","),
                image = ImageJpaEntity(album.image)
            )
        }
    }

    fun toAlbum(): Album {
        return Album(
            id = id,
            artistId = artistId,
            name = name,
            releaseDate = releaseDate,
            tags = tags.split(","),
            image = image.toImage()
        )
    }
}