package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetGenresResponse

@Dao
interface GenresDao {
   /* @Query("SELECT * FROM genres")
    fun getGenres() : LiveData<GetGenresResponse>*/

    @Query("SELECT * FROM genreList")
    fun getGenresList() : LiveData<List<GenreVO>>
/*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenres(genres:GetGenresResponse)*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(listOfGenres:List<GenreVO>)

    @Query("SELECT g.name FROM genreList as g WHERE id=:id")
    fun getGenreName(id:Int):String
}