package com.baktyiar.moviesomdbapi.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baktyiar.moviesomdbapi.data.local.model.MovieEntity
import com.baktyiar.moviesomdbapi.data.repository.MoviesRepository
import com.baktyiar.moviesomdbapi.data.repository.MoviesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject
constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    fun getAll(): Flow<List<MovieEntity>> = moviesRepository.getAll()
    fun findMovie(title: String) {
        viewModelScope.launch {
            moviesRepository.findMovie(title)
//
//            val values = remoteMovieDataSource.searchBy(title)
//            if (values != null) {
//                localMovieDataSource.deleteAll()
//                localMovieDataSource.insertAll(values)
//            } else {
//                //show that there is no result for that
//            }
        }
    }

}