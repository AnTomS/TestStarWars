package com.atom.teststarwars.domain.usecase.filmsusecase

import com.atom.teststarwars.domain.repository.filmsrepository.FilmsRepository

class GetFilmsListUseCase(private val filmsRepository: FilmsRepository) {
}