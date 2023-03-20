package com.baktyiar.moviesomdbapi.data.repository

import com.baktyiar.moviesomdbapi.data.remote.OmdbApiService
import javax.inject.Inject

class RemoteMovieDataSource @Inject constructor(private val apiService: OmdbApiService) {

    suspend fun searchBy(title: String) = apiService.search(title)
}