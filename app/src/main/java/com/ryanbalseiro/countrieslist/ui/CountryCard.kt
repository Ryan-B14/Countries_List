package com.ryanbalseiro.countrieslist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CountryCard(name: String, region: String, code: String, capital: String) {
    Card(modifier = Modifier.widthIn(60.dp, 300.dp).heightIn(60.dp, 60.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Row {
                Text("$name, ")
                Text(region)
                Spacer(Modifier.width(6.dp))
                Text(code)
            }
            Spacer(Modifier.height(10.dp))
            Text(capital)
        }
    }
}

@Preview
@Composable
fun CountryCardPreview() {
    CountryCard("United States of America", "NA", "US", "Washington D.C.")
}