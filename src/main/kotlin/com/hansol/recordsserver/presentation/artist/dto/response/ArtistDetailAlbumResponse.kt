package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.music.domain.Album
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.common.dto.ImageResponse

data class ArtistDetailAlbumResponse(
    val id: String,
    val name: String,
    val releaseDate: String,
    val tags: List<String>,
    val image: ImageResponse,
) {
    constructor(album: Album) : this(
        id = IdUtils.encode(album.id),
        name = album.name,
        releaseDate = DateTimeParser.toString(album.releaseDate.toLocalDate()),
        tags = album.tags,
        image = ImageResponse(album.image),
    )
}