package com.atom.teststarwars.data.repository.filmsrepositoryimpl

import android.util.Log
import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.domain.models.films.Kino
import com.atom.teststarwars.domain.repository.filmsrepository.FilmsRepository
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    FilmsRepository {
    override suspend fun getFilmsList(): LoadingState<List<Kino>> {
        val response = apiService.getFilmsList()
        return if (response.isSuccessful) {
            val data = response.body()
            Log.d("FilmsRepositoryImpl", data.toString())
            LoadingState.Success(data!!.results)

        } else {
            LoadingState.Error(response.message())
        }
    }
}
