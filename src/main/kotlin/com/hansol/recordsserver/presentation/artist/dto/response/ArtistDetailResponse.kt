package com.hansol.recordsserver.presentation.artist.dto.response

import com.hansol.recordsserver.application.artist.model.ArtistDetailModel
import com.hansol.recordsserver.common.utils.DateTimeParser
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.common.dto.ImageResponse

data class ArtistDetailResponse(
    val id: String,
    val name: String,
    val description: String,
    val debutDate: String,
    val status: String,
    val mainImage: ImageResponse,
    val members: List<ArtistMemberResponse>,

    val records: List<ArtistRecordResponse>,
) {

    constructor(artistDetailModel: ArtistDetailModel) : this(
        id = IdUtils.encode(artistDetailModel.id),
        name = artistDetailModel.name,
        description = artistDetailModel.description,
        debutDate = DateTimeParser.toString(artistDetailModel.debutDate.toLocalDate()),
        status = artistDetailModel.status.label,
        mainImage = ImageResponse(artistDetailModel.mainImage),
        members = artistDetailModel.members.map { ArtistMemberResponse(it) },
        records = artistDetailModel.records.map { ArtistRecordResponse(it) }
    )
}
