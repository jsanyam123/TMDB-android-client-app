package com.sanyam.tmdbclient.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sanyam.tmdbclient.domain.usecase.GetMoviesUseCase
import com.sanyam.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.sanyam.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.sanyam.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUsecase,
    private val getUpdateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun getTvShows() = liveData {
        val movieList = getTvShowsUseCase.execute()
        emit(movieList)
    }

    fun getUpdatedMovies() = liveData {
        val movieList = getUpdateMoviesUseCase.execute()
        emit(movieList)
    }

    fun getUpdatedTvShows() = liveData {
        val movieList = getUpdateTvShowsUseCase.execute()
        emit(movieList)
    }

}





