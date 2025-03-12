package com.ryanbalseiro.countrieslist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ryanbalseiro.countrieslist.data.api.CountriesIntent
import com.ryanbalseiro.countrieslist.ui.ListPage
import com.ryanbalseiro.countrieslist.ui.theme.CountriesListTheme

class MainActivity : ComponentActivity() {
    private val viewModel = CountriesViewModel()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountriesListTheme {
                viewModel.handleIntent(CountriesIntent.getCountries(""))
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ListPage(viewModel)
                }
            }
        }
    }
}

