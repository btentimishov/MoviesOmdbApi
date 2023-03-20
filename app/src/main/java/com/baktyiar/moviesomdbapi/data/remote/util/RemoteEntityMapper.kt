package com.baktyiar.moviesomdbapi.data.remote

import com.baktyiar.moviesomdbapi.data.util.EntityMapper
import com.baktyiar.moviesomdbapi.presentation.model.Movie
import javax.inject.Inject

class RemoteEntityMapper @Inject constructor() : EntityMapper<RemoteMovie, Movie> {

    fun entityListToMovieList(remoteEntities: List<RemoteMovie>): List<Movie> {
        val list: ArrayList<Movie> = ArrayList()
        for (entity in remoteEntities) {
            list.add(mapFromEntity(entity))
        }
        return list
    }

    fun movieListToEntityList(movies: List<Movie>): List<RemoteMovie> {
        val remoteEntities: ArrayList<RemoteMovie> = ArrayList()
        for (movie in movies) {
            remoteEntities.add(mapToEntity(movie))
        }
        return remoteEntities
    }


    override fun mapFromEntity(entity: RemoteMovie): Movie {
        return Movie(
            title = entity.title,
            year = entity.year,
            imdbId = entity.imdbId,
            type = entity.type,
            poster = entity.poster
        )
    }

    override fun mapToEntity(domainModel: Movie): RemoteMovie {
        return RemoteMovie(
            title = domainModel.title,
            year = domainModel.year,
            imdbId = domainModel.imdbId,
            type = domainModel.type,
            poster = domainModel.poster
        )
    }
}