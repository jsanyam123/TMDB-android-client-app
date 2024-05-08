package com.sanyam.tmdbclient.data.repository.movie.datasource

import com.sanyam.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
   suspend fun getMovies(): Response<MovieList>
}