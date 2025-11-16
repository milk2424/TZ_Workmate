package com.example.data.network.dto.response

sealed interface ApiResponse<out T> {
    data class Error(val code: Int) : ApiResponse<Nothing>
    data class Success<T>(val data: T) : ApiResponse<T>
}