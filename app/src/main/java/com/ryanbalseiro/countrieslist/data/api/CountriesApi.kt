package com.ryanbalseiro.countrieslist.data.api

import com.ryanbalseiro.countrieslist.data.model.countries.Countries
import retrofit2.http.GET

interface CountriesApi {

    @GET("countries.json")
    suspend fun getCountries(
    ): Countries

}