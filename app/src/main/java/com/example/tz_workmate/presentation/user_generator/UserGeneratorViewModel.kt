package com.example.tz_workmate.presentation.user_generator

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.local_data.repository.CountryRepository
import com.example.domain.local_data.repository.GenderRepository
import com.example.domain.user_generator.model.UserResponseState
import com.example.domain.user_generator.repository.UserRepository
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.Default
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.Empty
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.Loading
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.NetworkError
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.ServerError
import com.example.tz_workmate.presentation.user_generator.UserGeneratorState.Success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserGeneratorViewModel(
    private val countryRepository: CountryRepository,
    private val genderRepository: GenderRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private var _uiState: MutableStateFlow<UserGeneratorState> =
        MutableStateFlow(Default)

    val uiState = _uiState.asStateFlow()

    fun loadCountries() = countryRepository.getCountries()

    fun loadGenders() = genderRepository.getGenders()

    fun generateUser(gender: String, nat: String) {
        viewModelScope.launch {
            Log.i("TAG", "START SEARCH")
            userRepository.generateUser(gender, nat).collect { state ->
                when (state) {
                    is UserResponseState.Empty -> _uiState.value = Empty
                    is UserResponseState.ServerError -> _uiState.value = ServerError(state.message)
                    is UserResponseState.Loading -> _uiState.value = Loading
                    is UserResponseState.Success -> {
                        userRepository.insertUser(state.user)
                        _uiState.value = Success(state.user)
                    }
                    is UserResponseState.NetworkError -> _uiState.value = NetworkError
                }
            }
        }
    }

    fun setDefaultState() {
        _uiState.value = Default
    }

}