package com.example.data.storage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.data.storage.entity.UserEntity

@Dao
interface MainDao {

    @Query("SELECT * FROM users")
    suspend fun loadUsers(): List<UserEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Delete
    suspend fun removeUser(user: UserEntity)

}