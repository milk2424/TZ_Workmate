package com.example.tz_workmate.presentation.user_generator

import com.example.domain.user_generator.model.User

interface UserGeneratorState {
    data object Default : UserGeneratorState
    data object Loading : UserGeneratorState
    data class Success(val user: User) : UserGeneratorState
    data class ServerError(val message: String) : UserGeneratorState
    data object NetworkError : UserGeneratorState
    data object Empty : UserGeneratorState
}