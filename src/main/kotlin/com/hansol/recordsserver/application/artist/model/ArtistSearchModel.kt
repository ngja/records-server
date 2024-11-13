package com.hansol.recordsserver.application.artist.model

import com.hansol.recordsserver.application.artist.domain.Artist
import com.hansol.recordsserver.common.enums.ArtistStatus
import java.time.LocalDateTime

data class ArtistSearchModel(
    val id: String,
    val name: String,
    val debutDate: LocalDateTime,
    val status: ArtistStatus,
) {

    constructor(artist: Artist) : this(
        id = artist.id,
        name = artist.name,
        debutDate = artist.debutDate,
        status = artist.status,
    )
}
