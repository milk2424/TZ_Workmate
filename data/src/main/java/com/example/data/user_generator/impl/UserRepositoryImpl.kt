package com.example.data.user_generator.impl

import com.example.data.network.RandomUserService
import com.example.data.network.dto.toDomain
import com.example.domain.user_generator.model.UserResponseState
import com.example.domain.user_generator.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepositoryImpl(private val randomUserService: RandomUserService) : UserRepository {
    override fun generateUser(gender: String, nat: String) = flow {
        try {
            emit(UserResponseState.Loading)
            val response = randomUserService.getRandomUser(gender, nat)
            if (response.isSuccessful) {
                val user = response.body()?.toDomain()
                emit(
                    if (user == null) UserResponseState.Empty else UserResponseState.Success(user)
                )
            } else emit(UserResponseState.ServerError(response.message()))
        } catch (e: Throwable) {
            emit(UserResponseState.NetworkError)
        }
    }.flowOn(Dispatchers.IO)
}