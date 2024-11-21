package com.hansol.recordsserver.infrastructure.music.persistence.entity

import com.hansol.recordsserver.application.music.domain.Mv
import com.hansol.recordsserver.infrastructure.artist.persistence.entity.ArtistJpaEntity
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "mv")
@SQLRestriction("deleted = false")
class MvJpaEntity(
    @Id
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "artist_id")
    val artist: ArtistJpaEntity,

    @ManyToOne
    @JoinColumn(name = "song_id")
    val song: SongJpaEntity,

    @Column(nullable = false)
    val url: String,
) : AuditBaseEntity() {

    fun toMv(): Mv {
        return Mv(
            id = id,
            artist = artist.toArtist(),
            song = song.toSong(),
            url = url,
        )
    }
}