package com.atom.teststarwars.data.repository.peoplesrepositoryimpl

import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.domain.models.people.People
import com.atom.teststarwars.domain.repository.peoplerepository.PeopleRepository
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    PeopleRepository {
    override suspend fun getPeoplesList(): LoadingState<List<People>> {
        val response = apiService.getPeopleList()
        return if (response.isSuccessful) {
            val data = response.body()
            LoadingState.Success(data!!)
        } else {
            LoadingState.Error(response.message())
        }
    }
}