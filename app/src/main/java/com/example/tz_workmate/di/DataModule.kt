package com.example.tz_workmate.di

import com.example.data.local_data.LocalCountryDataSource
import com.example.data.local_data.LocalGenderDataSource
import org.koin.dsl.module

val dataModule = module {
    single {
        LocalCountryDataSource()
    }

    single {
        LocalGenderDataSource()
    }
}