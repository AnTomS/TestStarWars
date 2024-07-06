package com.atom.teststarwars.di

import android.util.Log
import com.atom.teststarwars.presentation.MainActivity
import com.atom.teststarwars.presentation.ui.films.FilmsFragment
import com.atom.teststarwars.presentation.ui.peoples.PeopleFragment
import com.atom.teststarwars.presentation.ui.planets.PlanetsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class, ViewModelModule::class, DomainModule::class])
interface AppComponent {


    fun inject(activity: MainActivity) {
        Log.d("AppComponent", "Injecting MainActivity")
    }

    fun inject(activity: PlanetsFragment) {
        Log.d("AppComponent", "Injecting MainActivity")
    }

    fun inject(activity: PeopleFragment) {
        Log.d("AppComponent", "Injecting MainActivity")
    }


    fun inject(activity: FilmsFragment) {
        Log.d("AppComponent", "Injecting MainActivity")
    }


}