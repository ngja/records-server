package com.hansol.recordsserver.application.country.service

import com.hansol.recordsserver.application.country.domain.Country
import com.hansol.recordsserver.application.country.repository.CountryWriteRepository
import org.springframework.stereotype.Service

@Service
class CountryCreateService(
    private val countryWriteRepository: CountryWriteRepository,
) {

    fun create(country: Country): Country {
        return countryWriteRepository.create(country)
    }

    fun createAll(countries: List<Country>): List<Country> {
        return countryWriteRepository.createAll(countries)
    }
}