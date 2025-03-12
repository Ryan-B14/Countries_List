package com.ryanbalseiro.countrieslist.data.repository

import com.ryanbalseiro.countrieslist.data.api.RetrofitInstance

class CountriesRepository {
    suspend fun getCountries() = RetrofitInstance.api.getCountries()
}