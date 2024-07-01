package com.atom.teststarwars.data.repository.planetsrepositoryimpl

import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.domain.repository.peoplerepository.PeopleRepository
import com.atom.teststarwars.domain.repository.planetsrepository.PlanetRepository
import javax.inject.Inject

class PlanetsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    PlanetRepository {
}