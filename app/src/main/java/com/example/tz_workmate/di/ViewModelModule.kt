package com.example.tz_workmate.di

import com.example.tz_workmate.presentation.user_generator.UserGeneratorViewModel
import com.example.tz_workmate.presentation.users.UsersViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        UserGeneratorViewModel(get(), get(), get())
    }

    viewModel {
        UsersViewModel(get())
    }

}