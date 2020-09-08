package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO

class GenresVOListTypeConverter {
    @TypeConverter
    fun toString(genresVOList:ArrayList<GenreVO>) : String {
        return Gson().toJson(genresVOList)
    }
    @TypeConverter
    fun toGenreVOList(genreVOListJsonString:String):ArrayList<GenreVO> {
        val genreVOListType = object :TypeToken<ArrayList<GenreVO>>(){}.type
        return Gson().fromJson(genreVOListJsonString,genreVOListType)
    }
}