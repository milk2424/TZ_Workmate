package com.example.tz_workmate.di

import com.example.tz_workmate.presentation.user_generator.UserGeneratorViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        UserGeneratorViewModel(get(),get())
    }
}