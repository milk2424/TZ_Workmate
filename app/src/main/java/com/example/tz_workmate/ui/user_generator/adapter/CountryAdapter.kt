package com.example.tz_workmate.ui.user_generator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.domain.local_data.model.Country
import com.example.tz_workmate.R
import com.example.tz_workmate.presentation.user_generator.mapper.CountryImageMapper

class CountryAdapter(context: Context, countries: List<Country>) :
    ArrayAdapter<Country>(context, 0, countries) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCustomView(position, convertView, parent)

    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return createCustomView(position, convertView, parent)
    }

    private fun createCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val country = getItem(position)

        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.item_spinner_country, parent, false)

        country?.let {
            val countryFlag: ImageView = view.findViewById(R.id.imgCountryFlag)
            val countryName: TextView = view.findViewById(R.id.tvCountryName)

            val resourceId = CountryImageMapper.mapFlagNameToResourceId(it.thumbnail)

            countryFlag.setImageResource(resourceId)
            countryName.text = it.name
        }
        return view
    }
}