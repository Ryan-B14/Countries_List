package com.ryanbalseiro.countrieslist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
    Card(modifier = Modifier
        .width(250.dp)
        .heightIn(60.dp, 160.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(60.dp, 160.dp)
                .padding(horizontal = 8.dp)
        ) {
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Text("$name, $region",
                    maxLines = 2,
                    softWrap = true,
                    modifier = Modifier.widthIn(max = 200.dp)
                    )
                Text(code)
            }
            Spacer(Modifier.height(10.dp))
            Text(capital)
            Spacer(Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun CountryCardPreview() {
    CountryCard("United States of America", "NA", "US", "Washington D.C.")
}