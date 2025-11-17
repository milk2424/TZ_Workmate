package com.example.tz_workmate.presentation.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.user_generator.model.User
import com.example.domain.users.model.DBState
import com.example.domain.users.repository.UsersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val usersRepository: UsersRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UsersState> = MutableStateFlow(UsersState.Empty)
    val uiState = _uiState.asStateFlow()


    fun loadUsers() {
        viewModelScope.launch {
            usersRepository.loadUsers().collect { state ->
                when (state) {
                    is DBState.Empty -> _uiState.value = UsersState.Empty
                    is DBState.Loading -> _uiState.value = UsersState.Loading
                    is DBState.Success -> _uiState.value = UsersState.Success(state.data)
                }
            }
        }
    }

    fun removeUser(user: User) {
        viewModelScope.launch {
            usersRepository.removeUser(user)
            loadUsers()
        }
    }


}