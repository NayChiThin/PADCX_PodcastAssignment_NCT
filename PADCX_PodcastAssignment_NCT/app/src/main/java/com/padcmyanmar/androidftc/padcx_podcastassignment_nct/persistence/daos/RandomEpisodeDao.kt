package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetRandomEpisodeResponse

@Dao
interface RandomEpisodeDao {
    @Query("SELECT * FROM random")
    fun getRandomEpisode():LiveData<GetRandomEpisodeResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRandomEpisode(randomEpisode:GetRandomEpisodeResponse)
}