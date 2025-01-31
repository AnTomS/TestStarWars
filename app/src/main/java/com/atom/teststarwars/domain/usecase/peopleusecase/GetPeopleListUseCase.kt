package com.atom.teststarwars.domain.usecase.peopleusecase

import com.atom.teststarwars.data.repository.peoplesrepositoryimpl.PeopleRepositoryImpl
import com.atom.teststarwars.domain.models.people.People
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class GetPeopleListUseCase @Inject constructor(private val peopleRepository: PeopleRepositoryImpl) {
    suspend operator fun invoke(): LoadingState<List<People>> {
        return try {
            peopleRepository.getPeoplesList()
        } catch (e: Exception) {
            throw e
        }
    }
}