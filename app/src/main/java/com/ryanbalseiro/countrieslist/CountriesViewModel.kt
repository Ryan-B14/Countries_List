package com.ryanbalseiro.countrieslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryanbalseiro.countrieslist.data.api.CountriesIntent
import com.ryanbalseiro.countrieslist.data.model.countries.Countries
import com.ryanbalseiro.countrieslist.data.model.countries.CountriesItem
import com.ryanbalseiro.countrieslist.data.repository.CountriesRepository
import kotlinx.coroutines.launch

private const val TAG = "CountriesViewModel"
class CountriesViewModel: ViewModel() {
    private val countriesRepository: CountriesRepository
        get() {
            CountriesRepository::class.java
            return CountriesRepository()
        }
    private val _masterCountriesList = MutableLiveData<Countries>()
    private val masterCountriesList: LiveData<Countries> = _masterCountriesList

    private val _countriesList = MutableLiveData<List<CountriesItem>>()
    val countriesList: LiveData<List<CountriesItem>> = _countriesList

    init {
        _masterCountriesList.observeForever { masterList ->
            _countriesList.value = masterList
        }
    }

    fun handleIntent(intent: CountriesIntent) {
        when (intent) {
            is CountriesIntent.getCountries -> {
                setCountriesMasterList()
            }
        }
    }

    fun filterCountriesListByName(query: String) {
        _countriesList.postValue(
            _masterCountriesList.value?.filter { country ->
                country.name.take(query.length).equals(query, ignoreCase = true)
            }
        )
    }

    fun filterCountriesListByCapital(query: String) {
        _countriesList.postValue(
            _masterCountriesList.value?.filter { country ->
                country.capital.take(query.length).equals(query, ignoreCase = true)
            }
        )
    }

    fun setCountriesListDefault() {
        _countriesList.value = masterCountriesList.value
    }

    private fun setCountriesMasterList() {
        viewModelScope.launch {
            try {
                _masterCountriesList.postValue(countriesRepository.getCountries())
            } catch (e: Exception) {
                Log.d(TAG, "getCountries: $e")
            }
        }
    }
}