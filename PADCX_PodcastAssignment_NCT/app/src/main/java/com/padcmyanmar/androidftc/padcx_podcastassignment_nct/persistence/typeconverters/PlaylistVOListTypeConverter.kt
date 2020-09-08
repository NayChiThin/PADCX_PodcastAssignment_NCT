package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.PlaylistVO

class PlaylistVOListTypeConverter {
    @TypeConverter
    fun toString(playlistVoList:ArrayList<PlaylistVO>) : String {
        return Gson().toJson(playlistVoList)
    }
    @TypeConverter
    fun toPlaylistVOList(playlistVOListJsonString:String): ArrayList<PlaylistVO> {
        val playlistVOListType = object :TypeToken<ArrayList<PlaylistVO>>(){}.type
        return Gson().fromJson(playlistVOListJsonString,playlistVOListType)
    }
}