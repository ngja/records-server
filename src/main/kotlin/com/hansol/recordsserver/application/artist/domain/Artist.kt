package com.hansol.recordsserver.application.artist.domain

import com.hansol.recordsserver.common.enums.ArtistStatus
import com.hansol.recordsserver.common.vo.Image
import java.time.LocalDateTime

class Artist(
    val id: Long,
    val name: String,
    val description: String,
    val debutDate: LocalDateTime,
    val status: ArtistStatus,
    val mainImage: Image,
) {

}