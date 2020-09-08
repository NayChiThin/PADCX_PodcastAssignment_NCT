package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetDetailResponse

@Dao
interface DetailDao {
    @Query("SELECT * FROM detail WHERE id = :id")
    fun getDetailById(id:String) : LiveData<GetDetailResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetail(detail:GetDetailResponse)
}