package com.example.data.local_data.impl

import com.example.data.local_data.LocalCountryDataSource
import com.example.domain.local_data.repository.CountryRepository

class CountryRepositoryImpl(private val source: LocalCountryDataSource) : CountryRepository {
    override fun getCountries() = source.getCountries().sortedBy { it.name }
}