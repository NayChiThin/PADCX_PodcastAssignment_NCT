package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreIdsListTypeConverter {
    @TypeConverter
    fun toString(genreIdsList:ArrayList<Int>):String {
        return Gson().toJson(genreIdsList)
    }
    @TypeConverter
    fun toGenreIdsList(genreIdsListJsonString:String):ArrayList<Int> {
        val genreIdsListType = object :TypeToken<ArrayList<Int>>(){}.type
        return Gson().fromJson(genreIdsListJsonString,genreIdsListType)
    }
}