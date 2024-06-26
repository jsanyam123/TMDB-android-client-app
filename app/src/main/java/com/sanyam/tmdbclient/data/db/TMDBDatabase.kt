package com.sanyam.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sanyam.tmdbclient.data.model.movie.Movie
import com.sanyam.tmdbclient.data.model.tvshow.TvShow


@Database(entities = [Movie::class, TvShow::class],
version = 1,
exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase(){
abstract fun movieDao(): MovieDao
abstract fun tvDao(): TvShowDao

}