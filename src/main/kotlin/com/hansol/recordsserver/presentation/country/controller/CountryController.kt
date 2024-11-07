package com.hansol.recordsserver.presentation.country.controller

import com.hansol.recordsserver.application.country.service.CountryCreateService
import com.hansol.recordsserver.application.country.service.CountryFindService
import com.hansol.recordsserver.presentation.common.dto.ResponseWrapper
import com.hansol.recordsserver.presentation.country.dto.request.CreateCountryRequest
import com.hansol.recordsserver.presentation.country.dto.response.CountryResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/countries")
class CountryController(
    private val countryFindService: CountryFindService,
    private val countryCreateService: CountryCreateService,
) {

    @GetMapping("")
    fun getCountries(): ResponseWrapper<List<CountryResponse>> {
        val countries = countryFindService.findAll()
        return ResponseWrapper.success(countries.map { CountryResponse.from(it) })
    }

    @PostMapping("")
    fun createCountries(@RequestBody createCountryRequest: List<CreateCountryRequest>): ResponseWrapper<List<CountryResponse>> {
        val countries = createCountryRequest.map { it.toCountry() }
        val results = countryCreateService.createAll(countries)
        return ResponseWrapper.success(results.map { CountryResponse.from(it) })
    }
}