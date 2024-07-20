package com.atom.teststarwars.domain.usecase.planetsusecase

import com.atom.teststarwars.data.repository.planetsrepositoryimpl.PlanetsRepositoryImpl
import com.atom.teststarwars.domain.models.planet.Planet
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class GetPlanetsListUseCase @Inject constructor(private val planetsRepository: PlanetsRepositoryImpl) {

    suspend operator fun invoke(): LoadingState<Planet> {
        return planetsRepository.getPlanetList()
    }
}