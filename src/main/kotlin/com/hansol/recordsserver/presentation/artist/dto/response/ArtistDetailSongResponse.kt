package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.music.domain.Song
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.utils.IdUtils

data class ArtistDetailSongResponse(
    val id: String,
    val record: String,
    val title: String,
    val lyrics: String,
    val composition: String,
    val arrangement: String,
    val releaseDate: String,
) {
    constructor(song: Song) : this(
        id = IdUtils.encode(song.id),
        record = song.album.name,
        title = song.title,
        lyrics = song.lyrics,
        composition = song.composition,
        arrangement = song.arrangement,
        releaseDate = DateTimeParser.toString(song.releaseDate.toLocalDate()),
    )
}
