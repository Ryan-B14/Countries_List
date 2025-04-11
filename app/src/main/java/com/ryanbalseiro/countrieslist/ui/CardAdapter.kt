package com.ryanbalseiro.countrieslist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ryanbalseiro.countrieslist.R
import com.ryanbalseiro.countrieslist.data.model.countries.Countries


class CardAdapter(private var countriesList: Countries?) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tv_country_name)
        val code: TextView = view.findViewById(R.id.tv_country_code)
        val region: TextView = view.findViewById(R.id.tv_country_region)
        val capital: TextView = view.findViewById(R.id.tv_country_capital)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_country_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardData = countriesList?.get(position)
        holder.name.text = "${cardData?.name}, "
        holder.code.text = cardData?.code
        holder.region.text = cardData?.region
        holder.capital.text = cardData?.capital
    }

    // Update the data in the adapter
    fun updateData(newList: Countries?) {
        countriesList = newList
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = countriesList?.size ?: 0
}