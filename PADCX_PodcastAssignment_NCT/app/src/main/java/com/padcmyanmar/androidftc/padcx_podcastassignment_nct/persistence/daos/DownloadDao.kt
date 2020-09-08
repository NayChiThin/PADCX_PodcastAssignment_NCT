package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters.DownloadVOListTypeConverter

@Dao
interface DownloadDao {
    @Query("SELECT * FROM download")
    fun getDownloadEpisodes():LiveData<List<DownloadVO>>

    @Query("SELECT * FROM download WHERE id=:id")
    fun getDownloadEpisodeById(id:String):LiveData<DownloadVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDownloadEpisode(episode:DownloadVO)
}