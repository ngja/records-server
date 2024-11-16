package com.hansol.recordsserver.application.artist.model

import com.hansol.recordsserver.application.artist.domain.Artist
import com.hansol.recordsserver.application.artist.domain.Member
import com.hansol.recordsserver.application.artist.domain.Members
import com.hansol.recordsserver.application.record.domain.Record
import com.hansol.recordsserver.application.record.domain.Records
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

    val records: List<Record>,
) {
    constructor(artist: Artist, members: Members, records: Records) : this(
        id = artist.id,
        name = artist.name,
        description = artist.description,
        debutDate = artist.debutDate,
        status = artist.status,
        mainImage = artist.mainImage,
        members = members.members,

        records = records.records
    )
}