package com.atom.teststarwars.di

import com.atom.teststarwars.data.repository.filmsrepositoryimpl.FilmsRepositoryImpl
import com.atom.teststarwars.data.repository.peoplesrepositoryimpl.PeopleRepositoryImpl
import com.atom.teststarwars.data.repository.planetsrepositoryimpl.PlanetsRepositoryImpl
import com.atom.teststarwars.domain.repository.filmsrepository.FilmsRepository
import com.atom.teststarwars.domain.repository.peoplerepository.PeopleRepository
import com.atom.teststarwars.domain.repository.planetsrepository.PlanetRepository
import com.atom.teststarwars.domain.usecase.filmsusecase.GetFilmsListUseCase
import com.atom.teststarwars.domain.usecase.peopleusecase.GetPeopleListUseCase
import com.atom.teststarwars.domain.usecase.planetsusecase.GetPlanetsListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideGetFilmsListUseCase(filmsRepository: FilmsRepositoryImpl): GetFilmsListUseCase {
        return GetFilmsListUseCase(filmsRepository)
    }

    @Singleton
    @Provides
    fun provideGetPeopleListUseCase(peopleRepository: PeopleRepositoryImpl): GetPeopleListUseCase {
        return GetPeopleListUseCase(peopleRepository)
    }

    @Singleton
    @Provides
    fun provideGetPlanetsListUseCase(planetsRepository: PlanetsRepositoryImpl): GetPlanetsListUseCase {
        return GetPlanetsListUseCase(planetsRepository)
    }


}