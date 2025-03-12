package com.ryanbalseiro.countrieslist.data.api

sealed class CountriesIntent {
    data class getCountries(val x: String) : CountriesIntent()
}