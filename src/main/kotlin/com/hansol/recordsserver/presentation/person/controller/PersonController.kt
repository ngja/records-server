package com.hansol.recordsserver.presentation.person.controller

import com.hansol.recordsserver.application.person.service.PersonCreateService
import com.hansol.recordsserver.presentation.common.dto.ResponseWrapper
import com.hansol.recordsserver.presentation.person.dto.request.PersonCreateRequest
import com.hansol.recordsserver.presentation.person.dto.response.PersonCreateResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/persons")
class PersonController(
    private val personCreateService: PersonCreateService,
) {
    @PostMapping("")
    fun create(@RequestBody personCreateRequest: PersonCreateRequest): ResponseWrapper<PersonCreateResponse> {
        val command = personCreateRequest.toCommand()
        val personDto = personCreateService.create(command)
        return ResponseWrapper.success(PersonCreateResponse.from(personDto))
    }
}