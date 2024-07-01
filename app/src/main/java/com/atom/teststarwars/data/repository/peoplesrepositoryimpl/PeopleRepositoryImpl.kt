package com.atom.teststarwars.data.repository.peoplesrepositoryimpl

import com.atom.teststarwars.data.network.ApiService
import com.atom.teststarwars.domain.repository.peoplerepository.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(private val apiService: ApiService) : PeopleRepository {
}