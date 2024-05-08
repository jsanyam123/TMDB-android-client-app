package com.sanyam.tmdbclient.data.repository.tvshow.datasource

import com.sanyam.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
   suspend fun getTvShows(): Response<TvShowList>
}