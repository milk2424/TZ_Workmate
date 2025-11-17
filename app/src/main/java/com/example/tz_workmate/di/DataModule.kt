package com.example.tz_workmate.di

import androidx.room.Room
import com.example.data.local_data.LocalCountryDataSource
import com.example.data.local_data.LocalGenderDataSource
import com.example.data.network.RandomUserService
import com.example.data.storage.MainDB
import com.example.data.storage.dao.MainDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        LocalCountryDataSource()
    }

    single {
        LocalGenderDataSource()
    }

    single<RandomUserService> {
        val baseUrl = "https://randomuser.me/"

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomUserService::class.java)
    }

    single<MainDao> {
        Room.databaseBuilder(androidContext(), MainDB::class.java, "main_database.db")
            .build().getDao()
    }

}