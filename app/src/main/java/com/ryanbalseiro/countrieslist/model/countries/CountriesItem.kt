package com.ryanbalseiro.countrieslist.model.countries

data class CountriesItem(
    val capital: String,
    val code: String,
    val currency: Currency?,
    val demonym: String?,
    val flag: String?,
    val language: Language?,
    val name: String,
    val region: String
)