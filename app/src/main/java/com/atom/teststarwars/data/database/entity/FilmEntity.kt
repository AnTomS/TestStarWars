package com.atom.teststarwars.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atom.teststarwars.domain.models.films.Result
import com.google.gson.annotations.SerializedName


@Entity(tableName = "film")
data class FilmEntity(
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("created")
    val created: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("episode_id")
    @PrimaryKey(autoGenerate = true)
    val episodeId: Int,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    @SerializedName("planets")
    val planets: List<String>,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("starships")
    val starships: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("vehicles")
    val vehicles: List<String>
) {
    fun toDomain(): Result =
        Result(
            characters = characters,
            created = created,
            director = director,
            edited = edited,
            episodeId = episodeId,
            openingCrawl = openingCrawl,
            planets = planets,
            producer = producer,
            releaseDate = releaseDate,
            species = species,
            starships = starships,
            title = title,
            url = url,
            vehicles = vehicles
        )

    companion object {
        fun fromDomain(film: Result): FilmEntity =
            FilmEntity(
                characters = film.characters,
                created = film.created,
                director = film.director,
                edited = film.edited,
                episodeId = film.episodeId,
                openingCrawl = film.openingCrawl,
                planets = film.planets,
                producer = film.producer,
                releaseDate = film.releaseDate,
                species = film.species,
                starships = film.starships,
                title = film.title,
                url = film.url,
                vehicles = film.vehicles
            )
    }
}