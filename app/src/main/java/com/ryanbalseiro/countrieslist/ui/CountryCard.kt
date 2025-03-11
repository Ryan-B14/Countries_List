package com.ryanbalseiro.countrieslist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CountryCard(name: String, region: String, code: String, capital: String) {
    Card() {
        Column {
            Row {
                Text(name)
                Text(region)
                Spacer(Modifier.width(6.dp))
                Text(code)
            }
            Text(capital)
        }
    }
}

@Preview
@Composable
fun CountryCardPreview() {
    CountryCard("United States of America", "NA", "US", "Washington D.C.")
}