package com.example.tz_workmate.presentation.users

import com.example.domain.user_generator.model.User

sealed interface UsersState {
    data object Empty : UsersState
    data object Loading : UsersState
    data class Success(val users: List<User>) : UsersState
}