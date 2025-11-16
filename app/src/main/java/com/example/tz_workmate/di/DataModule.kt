package com.example.tz_workmate.di

import com.example.data.local_data.LocalCountryDataSource
import com.example.data.local_data.LocalGenderDataSource
import com.example.data.network.RandomUserService
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
}