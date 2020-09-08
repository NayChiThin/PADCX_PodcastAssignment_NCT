package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO

class DownloadVOListTypeConverter {
    @TypeConverter
    fun toString(downloadVOList:ArrayList<DownloadVO>):String {
        return Gson().toJson(downloadVOList)
    }
    @TypeConverter
    fun toDownloadVOList(downloadVOListJsonString:String):ArrayList<DownloadVO> {
        val downloadVoListType = object : TypeToken<ArrayList<DownloadVO>>(){}.type
        return Gson().fromJson(downloadVOListJsonString,downloadVoListType)
    }
}