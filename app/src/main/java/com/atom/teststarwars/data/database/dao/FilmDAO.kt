package com.atom.teststarwars.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atom.teststarwars.data.database.entity.FilmEntity


@Dao
interface FilmDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: FilmEntity)

    @Query("SELECT * FROM film WHERE title = :filmName")
    suspend fun getFilmByName(filmName: String): FilmEntity?

    @Query("SELECT * FROM film")
    suspend fun getAllFilms(): List<FilmEntity>
}