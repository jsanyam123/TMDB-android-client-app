package com.sanyam.tmdbclient.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sanyam.tmdbclient.domain.usecase.GetMoviesUseCase
import com.sanyam.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.sanyam.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.sanyam.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class HomeViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val getUpdateMoviesUseCase: UpdateMoviesUsecase,
    private val getUpdateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(getMoviesUseCase, getTvShowsUseCase,getUpdateMoviesUseCase, getUpdateTvShowsUseCase) as T
    }
}

