package com.hansol.recordsserver.application.artist.service

import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.application.artist.model.ArtistDetailModel
import com.hansol.recordsserver.application.artist.model.ArtistSearchModel
import com.hansol.recordsserver.application.artist.repository.ArtistReadRepository
import com.hansol.recordsserver.application.artist.repository.MemberReadRepository
import org.springframework.stereotype.Service

@Service
class ArtistSearchService(
    private val artistReadRepository: ArtistReadRepository,
    private val memberReadRepository: MemberReadRepository,
) {
    fun search(command: ArtistSearchCommand): List<ArtistSearchModel> {
        val artistDomains = artistReadRepository.search(command)
        return artistDomains.map { ArtistSearchModel(it) }
    }

    fun detailById(artistId: Long): ArtistDetailModel {
        val artist = artistReadRepository.findById(artistId)
        val members = memberReadRepository.findByArtistId(artistId)
        return ArtistDetailModel(artist, members)
    }
}