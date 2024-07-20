package com.atom.teststarwars.di

import androidx.lifecycle.ViewModelProvider
import com.atom.teststarwars.domain.usecase.filmsusecase.GetFilmsListUseCase
import com.atom.teststarwars.domain.usecase.peopleusecase.GetPeopleListUseCase
import com.atom.teststarwars.domain.usecase.planetsusecase.GetPlanetsListUseCase
import com.atom.teststarwars.presentation.ViewModelFactory
import com.atom.teststarwars.presentation.ui.films.FilmsViewModel
import com.atom.teststarwars.presentation.ui.peoples.PeopleViewModel
import com.atom.teststarwars.presentation.ui.planets.PlanetsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Singleton
    @Provides
    fun providePeopleViewModelFactory(
        getPeopleListUseCase: GetPeopleListUseCase,
    ): ViewModelProvider.Factory {
        return ViewModelFactory { PeopleViewModel(getPeopleListUseCase) }
    }


    @Singleton
    @Provides
    fun providePlanetsViewModelFactory(
        getPlanetsListUseCase: GetPlanetsListUseCase,
    ): ViewModelProvider.Factory {
        return ViewModelFactory { PlanetsViewModel(getPlanetsListUseCase) }
    }


    @Singleton
    @Provides
    fun provideFilmsViewModelFactory(
        getFilmsListUseCase: GetFilmsListUseCase,
    ): ViewModelProvider.Factory {
        return ViewModelFactory { FilmsViewModel(getFilmsListUseCase) }
    }


}