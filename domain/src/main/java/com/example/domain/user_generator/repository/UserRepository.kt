package com.example.domain.user_generator.repository

import com.example.domain.user_generator.model.UserResponseState
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun generateUser(gender: String, nat: String): Flow<UserResponseState>

}