package com.atom.teststarwars.di

import android.app.Application
import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.data.repository.filmsrepositoryimpl.FilmsRepositoryImpl
import com.atom.teststarwars.data.repository.peoplesrepositoryimpl.PeopleRepositoryImpl
import com.atom.teststarwars.data.repository.planetsrepositoryimpl.PlanetsRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule(private val application: Application) {
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideFilmRepositoryImpl(
        apiService: ApiService
    ): FilmsRepositoryImpl {
        return FilmsRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun providePeopleRepositoryImpl(
        apiService: ApiService
    ): PeopleRepositoryImpl {
        return PeopleRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun providePlanetsRepositoryImpl(
        apiService: ApiService
    ): PlanetsRepositoryImpl {
        return PlanetsRepositoryImpl(apiService)
    }

}