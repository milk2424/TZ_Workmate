package com.example.tz_workmate

import android.app.Application
import com.example.tz_workmate.di.dataModule
import com.example.tz_workmate.di.repositoryModule
import com.example.tz_workmate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, repositoryModule, viewModelModule)
        }
    }
}