package com.baktyiar.moviesomdbapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)
data class MovieEntity(
    @PrimaryKey val imdbId: String,
    val title: String,
    val year: String,
    val type: String,
    val poster: String
)