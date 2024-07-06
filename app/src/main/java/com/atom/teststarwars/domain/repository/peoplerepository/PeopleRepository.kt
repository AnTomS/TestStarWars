package com.atom.teststarwars.domain.repository.peoplerepository

import com.atom.teststarwars.domain.models.people.People
import com.atom.teststarwars.presentation.state.LoadingState

interface PeopleRepository {
    suspend fun getPeoplesList(): LoadingState<List<People>>
}