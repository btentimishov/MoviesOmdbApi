package com.baktyiar.moviesomdbapi.data.repository

import com.baktyiar.moviesomdbapi.data.local.model.MovieEntity
import com.baktyiar.moviesomdbapi.presentation.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow


class FakeMoviesRepositoryImpl : MoviesRepository {

    val movies = listOf(
        Movie(
            "The Avengers",
            "2012",
            "tt0848228",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"
        ),
        Movie(
            "Inception",
            "2010",
            "tt1375666",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg"
        ),
        Movie(
            "The Dark Knight",
            "2008",
            "tt0468569",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg"
        ),
        Movie(
            "The Matrix",
            "1999",
            "tt0133093",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg"
        ),
        Movie(
            "Interstellar",
            "2014",
            "tt0816692",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1_SX300.jpg"
        ),
        Movie(
            "The Lord of the Rings: The Fellowship of the Ring",
            "2001",
            "tt0120737",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg"
        )
    )

    override fun getAll(): Flow<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun findMovie(title: String) {
        TODO("Not yet implemented")
    }
}