package com.hansol.recordsserver.presentation.person.controller

import com.hansol.recordsserver.application.person.service.PersonCreateService
import com.hansol.recordsserver.application.person.service.PersonSearchService
import com.hansol.recordsserver.presentation.common.dto.NoOffsetResponseWrapper
import com.hansol.recordsserver.presentation.common.dto.ResponseWrapper
import com.hansol.recordsserver.presentation.person.dto.request.PersonCreateRequest
import com.hansol.recordsserver.presentation.person.dto.request.PersonSearchRequest
import com.hansol.recordsserver.presentation.person.dto.response.PersonCreateResponse
import com.hansol.recordsserver.presentation.person.dto.response.PersonSearchResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/persons")
class PersonController(
    private val personCreateService: PersonCreateService,
    private val personSearchService: PersonSearchService,
) {
    @PostMapping("")
    fun create(@RequestBody personCreateRequest: PersonCreateRequest): ResponseWrapper<PersonCreateResponse> {
        val command = personCreateRequest.toCommand()
        val personDto = personCreateService.create(command)
        return ResponseWrapper.success(PersonCreateResponse.from(personDto))
    }

    @GetMapping("")
    fun search(request: PersonSearchRequest): NoOffsetResponseWrapper<PersonSearchResponse> {
        val searchResults = personSearchService.search(request.toCommand())
        val results = searchResults.map { PersonSearchResponse.from(it) }
        return NoOffsetResponseWrapper(results, request.size == results.size.toLong())
    }
}