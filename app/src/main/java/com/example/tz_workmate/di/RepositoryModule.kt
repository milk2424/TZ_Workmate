package com.example.tz_workmate.di

import com.example.data.local_data.impl.CountryRepositoryImpl
import com.example.data.local_data.impl.GenderRepositoryImpl
import com.example.domain.local_data.repository.CountryRepository
import com.example.domain.local_data.repository.GenderRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CountryRepository> {
        CountryRepositoryImpl(get())
    }

    single<GenderRepository> {
        GenderRepositoryImpl(get())
    }
}