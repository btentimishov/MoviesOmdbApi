package com.baktyiar.moviesomdbapi.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieEntity: MovieEntity)

    @Query("DELETE FROM movie WHERE imdbId = :imdbId")
    suspend fun deleteByUserId(imdbId: String)

    @Delete
    suspend fun delete(movieEntity: MovieEntity)

    @Query("DELETE FROM movie")
    suspend fun deleteAll()
}