package com.hansol.recordsserver.presentation.country.dto.request

import com.hansol.recordsserver.application.country.domain.Country

data class CreateCountryRequest(
    val id: Long,
    val name: String,
    val englishName: String,
    val alpha2: String,
    val alpha3: String,
) {
    fun toCountry(): Country {
        return Country(
            id = id,
            name = name,
            englishName = englishName,
            alpha2 = alpha2,
            alpha3 = alpha3,
        )
    }
}
