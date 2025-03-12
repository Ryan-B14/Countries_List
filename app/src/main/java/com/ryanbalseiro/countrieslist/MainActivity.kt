package com.ryanbalseiro.countrieslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ryanbalseiro.countrieslist.ui.ListPage
import com.ryanbalseiro.countrieslist.ui.theme.CountriesListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountriesListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListPage(innerPadding)
                }
            }
        }
    }
}

