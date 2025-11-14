package com.example.tz_workmate.presentation.user_generator

import androidx.lifecycle.ViewModel
import com.example.domain.local_data.repository.CountryRepository
import com.example.domain.local_data.repository.GenderRepository

class UserGeneratorViewModel(
    private val countryRepository: CountryRepository,
    private val genderRepository: GenderRepository
) : ViewModel() {


    fun loadCountries() = countryRepository.getCountries()

    fun loadGenders() = genderRepository.getGenders()

}