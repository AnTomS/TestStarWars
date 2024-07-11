package com.atom.teststarwars.domain.usecase.filmsusecase

import com.atom.teststarwars.data.repository.filmsrepositoryimpl.FilmsRepositoryImpl
import com.atom.teststarwars.domain.models.films.Kino
import com.atom.teststarwars.presentation.state.LoadingState

class GetFilmsListUseCase(private val filmsRepository: FilmsRepositoryImpl) {

    suspend operator fun invoke(): LoadingState<List<Kino>> {
        return filmsRepository.getFilmsList()
    }
}