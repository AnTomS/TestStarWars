package com.atom.teststarwars.domain.repository.planetsrepository

import com.atom.teststarwars.domain.models.planet.Planet
import com.atom.teststarwars.presentation.state.LoadingState

interface PlanetRepository {

    suspend fun getPlanetList(): LoadingState<Planet>
}