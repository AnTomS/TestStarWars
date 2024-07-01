package com.atom.teststarwars.domain.usecase.planetsusecase

import com.atom.teststarwars.domain.repository.planetsrepository.PlanetRepository

class GetPlanetsListUseCase(private val planetsRepository: PlanetRepository) {
}