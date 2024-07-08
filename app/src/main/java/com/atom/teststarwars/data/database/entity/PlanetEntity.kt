package com.atom.teststarwars.data.database.entity

import androidx.room.Entity
import com.atom.teststarwars.domain.models.planet.Planet
import com.google.gson.annotations.SerializedName


@Entity(tableName = "planet")
data class PlanetEntity(
    @SerializedName("climate")
    val climate: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("diameter")
    val diameter: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("gravity")
    val gravity: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("orbital_period")
    val orbitalPeriod: String,
    @SerializedName("population")
    val population: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("rotation_period")
    val rotationPeriod: String,
    @SerializedName("surface_water")
    val surfaceWater: String,
    @SerializedName("terrain")
    val terrain: String,
    @SerializedName("url")
    val url: String
) {
    fun toDomain(): Planet =
        Planet(
            climate = climate,
            created = created,
            diameter = diameter,
            edited = edited,
            films = films,
            gravity = gravity,
            name = name,
            orbitalPeriod = orbitalPeriod,
            population = population,
            residents = residents,
            rotationPeriod = rotationPeriod,
            surfaceWater = surfaceWater,
            terrain = terrain,
            url = url
        )

    companion object {
        fun fromDomain(planet: Planet): PlanetEntity =
            PlanetEntity(
                climate = planet.climate,
                created = planet.created,
                diameter = planet.diameter,
                edited = planet.edited,
                films = planet.films,
                gravity = planet.gravity,
                name = planet.name,
                orbitalPeriod = planet.orbitalPeriod,
                population = planet.population,
                residents = planet.residents,
                rotationPeriod = planet.rotationPeriod,
                surfaceWater = planet.surfaceWater,
                terrain = planet.terrain,
                url = planet.url
            )
    }
}