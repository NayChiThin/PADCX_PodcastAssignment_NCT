package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.*
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.daos.*
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters.DownloadVOListTypeConverter

@Database(
    entities = [GenreVO::class,GetGenresResponse::class, GetRandomEpisodeResponse::class,
        GetPlaylistInfoResponse::class, GetDetailResponse::class,DownloadVO::class],
    version = 8,
    exportSchema = false
)
abstract class PodcastDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PADCX-PODCAST.DB"
        var dbInstance : PodcastDB? = null
        fun getDbInstance(context: Context):PodcastDB {
            when(dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context,PodcastDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun randomEpisodeDao() : RandomEpisodeDao
    abstract fun genresDao() : GenresDao
    abstract fun playlistInfoDao() : PlaylistInfoDao
    abstract fun detailDao() : DetailDao
    abstract fun downloadDao() : DownloadDao
}