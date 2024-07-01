package com.atom.teststarwars.di

import android.util.Log
import com.atom.teststarwars.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class, ViewModelModule::class, DomainModule::class])
interface AppComponent {



    fun inject(activity: MainActivity) {
        Log.d("AppComponent", "Injecting MainActivity")
    }

}