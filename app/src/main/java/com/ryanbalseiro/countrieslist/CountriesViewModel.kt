package com.ryanbalseiro.countrieslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryanbalseiro.countrieslist.data.api.CountriesIntent
import com.ryanbalseiro.countrieslist.data.model.countries.Countries
import com.ryanbalseiro.countrieslist.data.repository.CountriesRepository
import kotlinx.coroutines.launch

private const val TAG = "CountriesViewModel"
class CountriesViewModel: ViewModel() {
    private val countriesRepository: CountriesRepository
        get() {
            CountriesRepository::class.java
            return CountriesRepository()
        }
    private val _countriesList = MutableLiveData<Countries>()
    val countriesList: LiveData<Countries> = _countriesList

    fun handleIntent(intent: CountriesIntent) {
        when (intent) {
            is CountriesIntent.getCountries -> {
                getCountries()
            }
        }
    }

    private fun getCountries() {
        viewModelScope.launch {
            try {
                _countriesList.postValue(countriesRepository.getCountries())
            } catch (e: Exception) {
                Log.d(TAG, "getCountries: $e")
            }
        }
    }
}