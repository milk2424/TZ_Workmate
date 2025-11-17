package com.example.domain.users.repository

import com.example.domain.user_generator.model.User
import com.example.domain.users.model.DBState
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun loadUsers(): Flow<DBState<List<User>>>

    suspend fun removeUser(user: User)

}