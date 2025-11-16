package com.example.tz_workmate.di

import com.example.data.local_data.impl.CountryRepositoryImpl
import com.example.data.local_data.impl.GenderRepositoryImpl
import com.example.data.user_generator.impl.UserRepositoryImpl
import com.example.domain.local_data.repository.CountryRepository
import com.example.domain.local_data.repository.GenderRepository
import com.example.domain.user_generator.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CountryRepository> {
        CountryRepositoryImpl(get())
    }

    single<GenderRepository> {
        GenderRepositoryImpl(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}