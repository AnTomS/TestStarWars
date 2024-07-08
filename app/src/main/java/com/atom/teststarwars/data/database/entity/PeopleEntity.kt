package com.atom.teststarwars.data.database.entity

import androidx.room.Entity
import com.atom.teststarwars.domain.models.people.People
import com.google.gson.annotations.SerializedName

@Entity(tableName = "people")
data class PeopleEntity(
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("homeworld")
    val homeWorld: String,
    @SerializedName("mass")
    val mass: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("species")
    val species: List<Any>,
    @SerializedName("starships")
    val starships: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("vehicles")
    val vehicles: List<String>
) {
    fun toDomain(): People =
        People(

            birthYear = birthYear,
            created = created,
            edited = edited,
            eyeColor = eyeColor,
            films = films,
            gender = gender,
            hairColor = hairColor,
            height = height,
            homeWorld = homeWorld,
            mass = mass,
            name = name,
            skinColor = skinColor,
            species = species,
            starships = starships,
            url = url,
            vehicles = vehicles
        )

    companion object {
        fun fromDomain(people: People): PeopleEntity =
            PeopleEntity(
                birthYear = people.birthYear,
                created = people.created,
                edited = people.edited,
                eyeColor = people.eyeColor,
                films = people.films,
                gender = people.gender,
                hairColor = people.hairColor,
                height = people.height,
                homeWorld = people.homeWorld,
                mass = people.mass,
                name = people.name,
                skinColor = people.skinColor,
                species = people.species,
                starships = people.starships,
                url = people.url,
                vehicles = people.vehicles
            )
    }
}