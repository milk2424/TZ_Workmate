package com.example.domain.users.model

sealed interface DBState<out T> {
    data object Loading : DBState<Nothing>
    data class Success<T>(val data: T) : DBState<T>
    data object Empty : DBState<Nothing>

}