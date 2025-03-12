package com.ryanbalseiro.countrieslist.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryanbalseiro.countrieslist.model.countries.CountriesItem

@Composable
fun ListPage(innerPadding: PaddingValues) {
    val countriesList = listOf(
        CountriesItem(
            name = "United States of America",
            capital = "Washington D.C.",
            code = "US",
            region = "NA",
            currency = null,
            demonym = null,
            flag = null,
            language = null
        ),
        CountriesItem(
            name = "Canada", capital = "Ottawa", code = "CA", region = "NA", currency = null,
            demonym = null, flag = null, language = null
        ),
        CountriesItem(
            name = "Uruguay", capital = "Montevideo", code = "UY", region = "SA", currency = null,
            demonym = null, flag = null, language = null
        ),
        CountriesItem(
            name = "England", capital = "London", code = "Eng", region = "EU", currency = null,
            demonym = null, flag = null, language = null
        ),
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { Spacer(modifier = Modifier.height(20.dp)) }
//        for (country in items) {
//            CountryCard(
//                capital = country.capital,
//                code = country.code,
//                name = country.name,
//                region = country.region
//            )
//        }
        items(countriesList) { country ->
            CountryCard(
                capital = country.capital,
                code = country.code,
                name = country.name,
                region = country.region
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

@Preview
@Composable
fun ListPagePreview() {
    ListPage(innerPadding = PaddingValues(400.dp))
}