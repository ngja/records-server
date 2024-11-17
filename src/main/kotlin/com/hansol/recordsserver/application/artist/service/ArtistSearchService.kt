package com.hansol.recordsserver.application.artist.service

import com.hansol.recordsserver.application.activity.repository.ConcertReadRepository
import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.application.artist.model.ArtistDetailModel
import com.hansol.recordsserver.application.artist.model.ArtistSearchModel
import com.hansol.recordsserver.application.artist.repository.ArtistReadRepository
import com.hansol.recordsserver.application.artist.repository.MemberReadRepository
import com.hansol.recordsserver.application.record.repository.RecordReadRepository
import com.hansol.recordsserver.application.song.repository.MvReadRepository
import com.hansol.recordsserver.application.song.repository.SongReadRepository
import org.springframework.stereotype.Service

@Service
class ArtistSearchService(
    private val artistReadRepository: ArtistReadRepository,
    private val memberReadRepository: MemberReadRepository,
    private val recordReadRepository: RecordReadRepository,
    private val songRepository: SongReadRepository,
    private val mvRepository: MvReadRepository,
    private val concertReadRepository: ConcertReadRepository,
) {
    fun search(command: ArtistSearchCommand): List<ArtistSearchModel> {
        val artistDomains = artistReadRepository.search(command)
        return artistDomains.map { ArtistSearchModel(it) }
    }

    fun detailById(artistId: Long): ArtistDetailModel {
        val artist = artistReadRepository.findById(artistId)
        val members = memberReadRepository.findByArtistId(artistId)
        val records = recordReadRepository.findByArtistIdLimit(artistId, 10L)
        val songs = songRepository.findByArtistIdLimit(artistId, 50L)
        val mvs = mvRepository.findByArtistIdLimit(artistId, 10L)
        val concerts = concertReadRepository.findByArtistIdLimit(artistId, 10L)
        return ArtistDetailModel(artist, members, records, songs, mvs, concerts)
    }
}