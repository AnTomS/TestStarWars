package com.atom.teststarwars.domain.usecase.peopleusecase

import com.atom.teststarwars.domain.repository.peoplerepository.PeopleRepository

class GetPeopleListUseCase(private val peopleRepository: PeopleRepository) {
}