package com.atom.teststarwars.data.repository.planetsrepositoryimpl

import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.domain.models.planet.Planet
import com.atom.teststarwars.domain.repository.planetsrepository.PlanetRepository
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class PlanetsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    PlanetRepository {
    override suspend fun getPlanetList(): LoadingState<Planet> {
        val response = apiService.getPlanetList()
        return if (response.isSuccessful) {
            val data = response.body()
            LoadingState.Success(data!!)
        } else {
            LoadingState.Error(response.message())
        }
    }
}