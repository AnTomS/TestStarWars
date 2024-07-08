package com.atom.teststarwars.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atom.teststarwars.data.database.dao.FilmDAO
import com.atom.teststarwars.data.database.dao.PeopleDAO
import com.atom.teststarwars.data.database.dao.PlanetDAO
import com.atom.teststarwars.data.database.entity.FilmEntity
import com.atom.teststarwars.data.database.entity.PeopleEntity
import com.atom.teststarwars.data.database.entity.PlanetEntity

@Database(
    entities = [
        FilmEntity::class,
        PlanetEntity::class,
        PeopleEntity::class,
    ],
    version = 2,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract val filmDAO: FilmDAO
    abstract val peopleDAO: PeopleDAO
    abstract val planetDAO: PlanetDAO
}