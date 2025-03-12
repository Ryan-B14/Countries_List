package com.ryanbalseiro.countrieslist.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryanbalseiro.countrieslist.CountriesViewModel

@Composable
fun ListPage(viewModel: CountriesViewModel) {
    val countriesList2 = viewModel.countriesList.observeAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { Spacer(modifier = Modifier.height(20.dp)) }
        if (!countriesList2.value.isNullOrEmpty()) {
            for (country in countriesList2.value!!) {
                item { CountryCard(
                    capital = country.capital,
                    code = country.code,
                    name = country.name,
                    region = country.region
                ) }
                item { Spacer(modifier = Modifier.height(6.dp)) }
            }
        } else {
            item { Text("No countries found.") }
        }
    }
}

@Preview
@Composable
fun ListPagePreview() {
    ListPage(viewModel = CountriesViewModel())
}