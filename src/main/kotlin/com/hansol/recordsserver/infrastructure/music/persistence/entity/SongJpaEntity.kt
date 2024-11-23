package com.hansol.recordsserver.infrastructure.music.persistence.entity

import com.hansol.recordsserver.application.music.domain.Song
import com.hansol.recordsserver.infrastructure.common.persistence.entity.AuditBaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "song")
@SQLRestriction("deleted = false")
class SongJpaEntity(
    @Id
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "album_id")
    val album: AlbumJpaEntity,

    @Column(nullable = false)
    val track: Int,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val lyrics: String,

    @Column(nullable = false)
    val composition: String,

    @Column(nullable = false)
    val arrangement: String,

) : AuditBaseEntity() {

    companion object {
        fun from(song: Song): SongJpaEntity {
            return SongJpaEntity(
                id = song.id,
                album = AlbumJpaEntity.from(song.album),
                track = song.track,
                title = song.title,
                lyrics = song.lyrics,
                composition = song.composition,
                arrangement = song.arrangement,
            )
        }
    }

    fun toSong(): Song {
        return Song(
            id = id,
            album = album.toAlbum(),
            track = track,
            title = title,
            lyrics = lyrics,
            composition = composition,
            arrangement = arrangement,
        )
    }
}