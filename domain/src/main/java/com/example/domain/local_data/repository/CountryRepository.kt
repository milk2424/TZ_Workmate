package com.example.domain.local_data.repository

import com.example.domain.local_data.model.Country

interface CountryRepository {

    fun getCountries(): List<Country>

}