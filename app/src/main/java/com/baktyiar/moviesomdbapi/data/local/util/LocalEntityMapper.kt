package com.baktyiar.moviesomdbapi.data.local

import com.baktyiar.moviesomdbapi.data.util.EntityMapper
import com.baktyiar.moviesomdbapi.presentation.model.Movie
import javax.inject.Inject

class LocalEntityMapper @Inject constructor() : EntityMapper<MovieEntity, Movie> {

    fun entityListToMovieList(localEntities: List<MovieEntity>): List<Movie> {
        val list: ArrayList<Movie> = ArrayList()
        for (entity in localEntities) {
            list.add(mapFromEntity(entity))
        }
        return list
    }

    fun movieListToEntityList(movies: List<Movie>): List<MovieEntity> {
        val localEntities: ArrayList<MovieEntity> = ArrayList()
        for (movie in movies) {
            localEntities.add(mapToEntity(movie))
        }
        return localEntities
    }

    override fun mapFromEntity(entity: MovieEntity): Movie {
        return Movie(
            title = entity.title,
            year = entity.year,
            imdbId = entity.imdbId,
            type = entity.type,
            poster = entity.poster
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieEntity {
        return MovieEntity(
            title = domainModel.title,
            year = domainModel.year,
            imdbId = domainModel.imdbId,
            type = domainModel.type,
            poster = domainModel.poster
        )
    }
}