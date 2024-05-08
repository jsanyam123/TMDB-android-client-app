package com.sanyam.tmdbclient.presentation.di.movie

import com.sanyam.tmdbclient.domain.usecase.GetMoviesUseCase
import com.sanyam.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.sanyam.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}