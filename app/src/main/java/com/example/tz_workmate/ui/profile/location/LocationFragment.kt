package com.example.tz_workmate.ui.profile.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tz_workmate.databinding.FragmentLocationBinding
import com.example.tz_workmate.ui.utils.FragmentBinding


class LocationFragment : FragmentBinding<FragmentLocationBinding>() {


    override fun bind(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentLocationBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            binding.tvCountryValue.text = it.getString(COUNTRY)
            binding.tvStateValue.text = it.getString(STATE)
            binding.tvCityValue.text = it.getString(CITY)
            binding.tvPostcodeValue.text = it.getString(POSTCODE)
            binding.tvStreetValue.text = it.getString(STREET)
        }
    }

    companion object {

        private const val COUNTRY = "country"
        private const val STATE = "state"
        private const val CITY = "city"
        private const val POSTCODE = "postcode"
        private const val STREET = "street"

        fun newInstance(
            country: String,
            state: String,
            city: String,
            postcode: String,
            street: String
        ) =
            LocationFragment().apply {
                arguments = Bundle().apply {
                    putString(COUNTRY, country)
                    putString(STATE, state)
                    putString(CITY, city)
                    putString(POSTCODE, postcode)
                    putString(STREET, street)
                }
            }
    }
}