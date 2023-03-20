package com.baktyiar.moviesomdbapi.domain

import android.content.Context
import androidx.room.Room
import com.baktyiar.moviesomdbapi.data.local.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): MovieDatabase {
        return Room.databaseBuilder(
            context = appContext,
            MovieDatabase::class.java, MovieDatabase.DATABASE_NAME
        ).build()
    }}