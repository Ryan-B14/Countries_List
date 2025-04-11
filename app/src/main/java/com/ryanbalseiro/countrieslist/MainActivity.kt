package com.ryanbalseiro.countrieslist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryanbalseiro.countrieslist.data.api.CountriesIntent
import com.ryanbalseiro.countrieslist.data.api.PlaceholderData
import com.ryanbalseiro.countrieslist.ui.CardAdapter
import com.ryanbalseiro.countrieslist.utils.ItemDecoration

class MainActivity : ComponentActivity() {
    private val viewModel = CountriesViewModel()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        viewModel.handleIntent(CountriesIntent.getCountries(""))
        val recyclerView = findViewById<RecyclerView>(R.id.rv_recyclerview)
        val adapter = CardAdapter(PlaceholderData.countriesList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_6dp)
        recyclerView.addItemDecoration(ItemDecoration(spacingInPixels))

        viewModel.countriesList.observe(this, Observer { cardList ->
            adapter.updateData(viewModel.countriesList.value)
        })
    }
}

