package com.atom.teststarwars.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atom.teststarwars.data.database.entity.PlanetEntity

@Dao
interface PlanetDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlanet(planet: PlanetEntity)

    @Query("SELECT * FROM planet WHERE name = :planetName")
    suspend fun getPlanetByName(planetName: String): PlanetEntity?

    @Query("SELECT * FROM film")
    suspend fun getAllPlanets(): List<PlanetEntity>
}