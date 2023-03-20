package com.baktyiar.moviesomdbapi.domain

import com.baktyiar.moviesomdbapi.data.remote.OmdbApiService
import com.baktyiar.moviesomdbapi.data.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://www.omdbapi.com"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideAppDatabase(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): OmdbApiService =
        retrofit.create(OmdbApiService::class.java)


//    @Singleton
//    @Provides
//    fun providesRepository(apiService: OmdbApiService) = MoviesRepository(apiService)
}