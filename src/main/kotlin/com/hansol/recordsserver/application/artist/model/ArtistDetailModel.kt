package com.hansol.recordsserver.application.artist.model

import com.hansol.recordsserver.application.activity.domain.Concert
import com.hansol.recordsserver.application.activity.domain.Concerts
import com.hansol.recordsserver.application.artist.domain.Artist
import com.hansol.recordsserver.application.artist.domain.Member
import com.hansol.recordsserver.application.artist.domain.Members
import com.hansol.recordsserver.application.music.domain.Album
import com.hansol.recordsserver.application.music.domain.Albums
import com.hansol.recordsserver.application.music.domain.Mv
import com.hansol.recordsserver.application.music.domain.Mvs
import com.hansol.recordsserver.application.music.domain.Song
import com.hansol.recordsserver.application.music.domain.Songs
import com.hansol.recordsserver.common.enums.ArtistStatus
import com.hansol.recordsserver.common.vo.Image
import java.time.LocalDateTime

data class ArtistDetailModel(
    val id: Long,
    val name: String,
    val description: String,
    val debutDate: LocalDateTime,
    val status: ArtistStatus,
    val mainImage: Image,
    val members: List<Member>,

    val albums: List<Album>,
    val songs: List<Song>,
    val mvs: List<Mv>,
    val concerts: List<Concert>,
) {
    constructor(
        artist: Artist,
        members: Members,
        albums: Albums,
        songs: Songs,
        mvs: Mvs,
        concerts: Concerts,
    ) : this(
        id = artist.id,
        name = artist.name,
        description = artist.description,
        debutDate = artist.debutDate,
        status = artist.status,
        mainImage = artist.mainImage,
        members = members.members,

        albums = albums.albums,
        songs = songs.songs,
        mvs = mvs.mvs,
        concerts = concerts.concerts,
    )
}
