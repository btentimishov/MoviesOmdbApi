package com.baktyiar.moviesomdbapi.data.repository

import com.baktyiar.moviesomdbapi.data.local.model.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject
constructor(
    private val localMovieDataSource: LocalMovieDataSource,
    private val remoteMovieDataSource: RemoteMovieDataSource,
) : MoviesRepository {

    override fun getAll(): Flow<List<MovieEntity>> = localMovieDataSource.getAll()

    override suspend fun findMovie(title: String) {
        val values = remoteMovieDataSource.searchBy(title)
        if (values != null) {
            localMovieDataSource.deleteAll()
            localMovieDataSource.insertAll(values)
        } else {
            //show that there is no result for that
        }

    }
}