package com.atom.teststarwars.presentation

import android.app.Application
import android.util.Log
import com.atom.teststarwars.di.AppComponent
import com.atom.teststarwars.di.AppModule
import com.atom.teststarwars.di.DaggerAppComponent
import com.atom.teststarwars.di.DataModule
import com.atom.teststarwars.di.DomainModule
import com.atom.teststarwars.di.NetworkModule
import com.atom.teststarwars.di.ViewModelModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .domainModule(DomainModule())
            .dataModule(DataModule(this))
            .viewModelModule(ViewModelModule())
            .build()

        Log.d("App", "AppComponent initialized: $appComponent")
    }
}