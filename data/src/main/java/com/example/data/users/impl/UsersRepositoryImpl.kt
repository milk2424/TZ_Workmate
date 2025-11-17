package com.example.data.users.impl

import com.example.data.storage.dao.MainDao
import com.example.data.storage.mapper.EntityMapper
import com.example.domain.user_generator.model.User
import com.example.domain.users.model.DBState
import com.example.domain.users.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsersRepositoryImpl(
    private val dao: MainDao
) : UsersRepository {
    override suspend fun loadUsers(): Flow<DBState<List<User>>> = flow {
        emit(DBState.Loading)
        val users = dao.loadUsers()
        if (users.isEmpty()) emit(DBState.Empty)
        else emit(DBState.Success(users.map { EntityMapper.map(it) }))

    }

    override suspend fun removeUser(user: User) {
        dao.removeUser(EntityMapper.map(user))
    }
}