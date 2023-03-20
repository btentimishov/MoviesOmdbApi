package com.baktyiar.moviesomdbapi.data.repository

import com.baktyiar.moviesomdbapi.data.local.model.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getAll(): Flow<List<MovieEntity>>
    suspend fun findMovie(title: String)
}
