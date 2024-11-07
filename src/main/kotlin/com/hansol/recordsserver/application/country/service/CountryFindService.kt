package com.hansol.recordsserver.application.country.service

import com.hansol.recordsserver.application.country.domain.Country
import com.hansol.recordsserver.application.country.repository.CountryReadRepository
import org.springframework.stereotype.Service

@Service
class CountryFindService(
    private val countryReadRepository: CountryReadRepository,
) {

    fun findAll(): List<Country> {
        return countryReadRepository.getAllCountries()
    }
}