package com.ryanbalseiro.countrieslist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryanbalseiro.countrieslist.CountriesViewModel
import com.ryanbalseiro.countrieslist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPage(viewModel: CountriesViewModel) {
    val countriesLocalList = viewModel.countriesList.observeAsState()
    val queryState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            query = queryState.value,
            onQueryChange = {
                queryState.value = it
                if (queryState.value.isEmpty() || queryState.value.isBlank()) {
                    viewModel.setCountriesListDefault()
                } else {
                    viewModel.filterCountriesListByName(queryState.value)
                }
            },
            onSearch = {
                //add ability to filter by capital as well
            },
            active = false,
            onActiveChange = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            placeholder = { Text("Search by country name") },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "Search Icon"
                )
            }
        ) {
            //content of the search bar, if needed
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { Spacer(modifier = Modifier.height(20.dp)) }
            if (!countriesLocalList.value.isNullOrEmpty()) {
                for (country in countriesLocalList.value!!) {
                    item {
                        CountryCard(
                            capital = country.capital,
                            code = country.code,
                            name = country.name,
                            region = country.region
                        )
                    }
                    item { Spacer(modifier = Modifier.height(6.dp)) }
                }
            } else {
                item { Text("No countries found.") }
            }
        }
    }

}

@Preview
@Composable
fun ListPagePreview() {
    ListPage(viewModel = CountriesViewModel())
}