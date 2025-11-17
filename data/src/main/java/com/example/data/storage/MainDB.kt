package com.example.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.storage.dao.MainDao
import com.example.data.storage.entity.UserEntity


@Database([UserEntity::class], version = 1)
abstract class MainDB : RoomDatabase() {
    abstract fun getDao(): MainDao
}