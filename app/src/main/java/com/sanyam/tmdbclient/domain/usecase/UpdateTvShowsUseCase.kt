package com.sanyam.tmdbclient.domain.usecase

import com.sanyam.tmdbclient.data.model.tvshow.TvShow
import com.sanyam.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}