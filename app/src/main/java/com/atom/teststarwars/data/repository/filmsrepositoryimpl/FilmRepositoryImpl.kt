package com.atom.teststarwars.data.repository.filmsrepositoryimpl

import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.domain.repository.filmsrepository.FilmsRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(private val apiService: ApiService) : FilmsRepository {
}