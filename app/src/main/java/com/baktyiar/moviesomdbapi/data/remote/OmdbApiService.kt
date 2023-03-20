package com.baktyiar.moviesomdbapi.data.remote

import com.wil8dev.pixture.model.Search
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val OMDB_API_KEY = "114e0ed7"

interface OmdbApiService {

    @GET(".")
    suspend fun search(
        @Query("s") searchText: String,
        @Query("apikey") key: String = OMDB_API_KEY
    ): Response<Search>

    @GET("/")
    suspend fun getMovie(
        @Query("i") movieId: String,
        @Query("apikey") key: String = OMDB_API_KEY
    ): Call<RemoteMovie>
}