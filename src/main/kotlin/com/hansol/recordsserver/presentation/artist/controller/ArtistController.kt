package com.hansol.recordsserver.presentation.artist.controller

import com.hansol.recordsserver.application.artist.service.ArtistSearchService
import com.hansol.recordsserver.common.utils.IdUtils
import com.hansol.recordsserver.presentation.artist.dto.request.ArtistSearchRequest
import com.hansol.recordsserver.presentation.artist.dto.response.ArtistDetailResponse
import com.hansol.recordsserver.presentation.artist.dto.response.ArtistSearchResponse
import com.hansol.recordsserver.presentation.common.dto.NoOffsetResponseWrapper
import com.hansol.recordsserver.presentation.common.dto.ResponseWrapper
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/artists")
class ArtistController(
    private val artistSearchService: ArtistSearchService,
) {
    @GetMapping("")
    fun search(request: ArtistSearchRequest): NoOffsetResponseWrapper<ArtistSearchResponse> {
        val artistSearchDomains = artistSearchService.search(request.toCommand())
        val results = artistSearchDomains.map { ArtistSearchResponse(it) }
        return NoOffsetResponseWrapper(results, request.size == results.size.toLong())
    }

    @GetMapping("/{artistId}")
    fun detail(@PathVariable artistId: String): ResponseWrapper<ArtistDetailResponse> {
        val artistDetailDomain = artistSearchService.detailById(IdUtils.decode(artistId))
        return ResponseWrapper.success(ArtistDetailResponse(artistDetailDomain))
    }
}