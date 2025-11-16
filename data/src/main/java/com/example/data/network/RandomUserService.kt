package com.example.data.network

import com.example.data.network.dto.UserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {
    @GET("api")
    suspend fun getRandomUser(
        @Query("gender") gender: String,
        @Query("nat") nat: String
    ): Response<UserDTO>
}