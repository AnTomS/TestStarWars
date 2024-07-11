package com.atom.teststarwars.domain.repository.filmsrepository

import com.atom.teststarwars.domain.models.films.Kino
import com.atom.teststarwars.presentation.state.LoadingState

interface FilmsRepository {
    suspend fun getFilmsList(): LoadingState<List<Kino>>
}