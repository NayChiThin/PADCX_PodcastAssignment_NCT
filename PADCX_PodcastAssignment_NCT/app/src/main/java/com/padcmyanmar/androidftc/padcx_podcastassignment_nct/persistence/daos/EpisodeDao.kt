package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO

@Dao
interface EpisodeDao {
    @Query("SELECT * FROM episodes")
    fun getEpisodes() : LiveData<List<DataVO>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodes(episodeList:List<DataVO>)
    @Query("SELECT * FROM episodes WHERE id = :id")
    fun getDetailById(id:String):LiveData<DataVO>
    @Query("SELECT * FROM episodes ORDER BY RANDOM() LIMIT 1")
    fun getRandomEpisode() : LiveData<DataVO>
    @Query("DELETE FROM episodes")
    fun deleteEpisodes()
}