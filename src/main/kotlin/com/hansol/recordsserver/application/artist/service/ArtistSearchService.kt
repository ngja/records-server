package com.hansol.recordsserver.application.artist.service

import com.hansol.recordsserver.application.activity.repository.ConcertReadRepository
import com.hansol.recordsserver.application.artist.command.ArtistSearchCommand
import com.hansol.recordsserver.application.artist.model.ArtistDetailModel
import com.hansol.recordsserver.application.artist.model.ArtistSearchModel
import com.hansol.recordsserver.application.artist.repository.ArtistReadRepository
import com.hansol.recordsserver.application.artist.repository.MemberReadRepository
import com.hansol.recordsserver.application.music.repository.AlbumReadRepository
import com.hansol.recordsserver.application.music.repository.MvReadRepository
import com.hansol.recordsserver.application.music.repository.SongReadRepository
import org.springframework.stereotype.Service

@Service
class ArtistSearchService(
    private val artistReadRepository: ArtistReadRepository,
    private val memberReadRepository: MemberReadRepository,
    private val albumReadRepository: AlbumReadRepository,
    private val songReadRepository: SongReadRepository,
    private val mvReadRepository: MvReadRepository,
    private val concertReadRepository: ConcertReadRepository,
) {
    fun search(command: ArtistSearchCommand): List<ArtistSearchModel> {
        val artistDomains = artistReadRepository.search(command)
        return artistDomains.map { ArtistSearchModel(it) }
    }

    fun detailById(artistId: Long): ArtistDetailModel {
        val artist = artistReadRepository.findById(artistId)
        val members = memberReadRepository.findByArtistId(artistId)
        val albums = albumReadRepository.findByArtistId(artistId, 10L)
        val songs = songReadRepository.findByArtistId(artistId, 50L)
        val mvs = mvReadRepository.findByArtistId(artistId, 10L)
        val concerts = concertReadRepository.findByArtistId(artistId, 10L)
        return ArtistDetailModel(artist, members, albums, songs, mvs, concerts)
    }
}