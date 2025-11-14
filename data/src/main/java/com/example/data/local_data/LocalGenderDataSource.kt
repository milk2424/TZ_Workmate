package com.example.data.local_data

import com.example.domain.local_data.model.Gender

class LocalGenderDataSource {

    fun getGenders() = listOf(
        Gender("Male", "ic_male"),
        Gender("Female", "ic_female"),
        Gender("Random", "ic_random")
    )
}