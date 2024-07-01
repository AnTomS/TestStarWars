package com.atom.teststarwars.data.network

import com.atom.teststarwars.domain.models.films.Films
import com.atom.teststarwars.domain.models.people.People
import com.atom.teststarwars.domain.models.planet.Planet
import retrofit2.http.GET

interface ApiService {

    @GET("planets/1")
    suspend fun getPlanetList(): Planet

    @GET("people/1")
    suspend fun getPeopleList1(): People

    @GET("films")
    suspend fun getFilmsList(): Films

}