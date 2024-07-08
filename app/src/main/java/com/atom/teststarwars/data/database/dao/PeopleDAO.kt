package com.atom.teststarwars.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atom.teststarwars.data.database.entity.PeopleEntity

@Dao
interface PeopleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPeople(people: PeopleEntity)

    @Query("SELECT * FROM people WHERE name = :peopleName")
    suspend fun getPeopleByName(peopleName: String): PeopleEntity?

    @Query("SELECT * FROM people")
    suspend fun getAllPeople(): List<PeopleEntity>
}