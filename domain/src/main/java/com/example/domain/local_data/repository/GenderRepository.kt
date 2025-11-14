package com.example.domain.local_data.repository

import com.example.domain.local_data.model.Country
import com.example.domain.local_data.model.Gender

interface GenderRepository {
    fun getGenders(): List<Gender>
}