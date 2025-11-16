package com.example.domain.user_generator.model

sealed interface UserResponseState {
    data object Loading : UserResponseState
    data class Success(val user: User) : UserResponseState
    data class ServerError(val message: String) : UserResponseState
    data object NetworkError : UserResponseState
    data object Empty : UserResponseState
}