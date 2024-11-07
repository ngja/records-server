package com.hansol.recordsserver.presentation.country.dto.response

import com.hansol.recordsserver.application.country.domain.Country

data class CountryResponse(
    val id: Long,
    val name: String,
    val englishName: String,
    val alpha2: String,
    val alpha3: String,
) {
    companion object {
        fun from(country: Country): CountryResponse {
            return CountryResponse(
                id = country.id,
                name = country.name,
                englishName = country.englishName,
                alpha2 = country.alpha2,
                alpha3 = country.alpha3,
            )
        }
    }
}
