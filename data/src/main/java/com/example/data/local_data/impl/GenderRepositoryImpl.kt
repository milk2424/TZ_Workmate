package com.example.data.local_data.impl

import com.example.data.local_data.LocalGenderDataSource
import com.example.domain.local_data.repository.GenderRepository

class GenderRepositoryImpl(private val source: LocalGenderDataSource) : GenderRepository {
    override fun getGenders() = source.getGenders()
}