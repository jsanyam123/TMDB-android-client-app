package com.sanyam.tmdbclient.domain.usecase

import com.sanyam.tmdbclient.data.model.movie.Movie
import com.sanyam.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}