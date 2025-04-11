package com.ryanbalseiro.countrieslist.data.api

import com.ryanbalseiro.countrieslist.data.model.countries.Countries
import com.ryanbalseiro.countrieslist.data.model.countries.CountriesItem

object PlaceholderData {
    val countriesList: Countries = Countries().apply {
        CountriesItem(
            name = "United States of America",
            region = "NA",
            code = "US",
            capital = "Washington D.C.",
            currency = null,
            demonym = null,
            flag = null,
            language = null
        )
        CountriesItem(
            name = "United States of America",
            region = "NA",
            code = "US",
            capital = "Washington D.C.",
            currency = null,
            demonym = null,
            flag = null,
            language = null
        )
    }
}