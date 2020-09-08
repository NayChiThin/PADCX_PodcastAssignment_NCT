package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetPlaylistInfoResponse

@Dao
interface PlaylistInfoDao {
    @Query("SELECT * FROM playlistInfo")
    fun getPlaylistInfo() : LiveData<GetPlaylistInfoResponse>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaylistInfo(playlist:GetPlaylistInfoResponse)
}