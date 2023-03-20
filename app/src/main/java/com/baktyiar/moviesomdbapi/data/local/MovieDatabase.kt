package com.baktyiar.moviesomdbapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun moviesDao(): MovieDao

    companion object {
        val DATABASE_NAME: String = "movies_db"
    }
}