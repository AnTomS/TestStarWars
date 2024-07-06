package com.atom.teststarwars.data.repository.filmsrepositoryimpl

import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.domain.models.films.Result
import com.atom.teststarwars.domain.repository.filmsrepository.FilmsRepository
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    FilmsRepository {
    override suspend fun getFilmsList(): LoadingState<List<Result>> {
        val response = apiService.getFilmsList()
        return if (response.isSuccessful) {
            val data = response.body()
            LoadingState.Success(data!!.results)
        } else {
            LoadingState.Error(response.message())
        }
    }
}
