package com.atom.teststarwars.presentation.ui.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.teststarwars.domain.models.planet.Planet
import com.atom.teststarwars.domain.usecase.planetsusecase.GetPlanetsListUseCase
import com.atom.teststarwars.presentation.state.LoadingState
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetsViewModel @Inject constructor(private val getPlanetsListUseCase: GetPlanetsListUseCase) :
    ViewModel() {
    private val _planets = MutableLiveData<LoadingState<Planet>>()
    val planets: LiveData<LoadingState<Planet>> get() = _planets

    fun getPlanetsList() {
        viewModelScope.launch {
            _planets.value = LoadingState.Loading
            try {
                val requestPlanetsList = getPlanetsListUseCase()
                _planets.value = requestPlanetsList
            } catch (e: Exception) {
                _planets.value = LoadingState.Error(e.toString())
            }
        }
    }
}