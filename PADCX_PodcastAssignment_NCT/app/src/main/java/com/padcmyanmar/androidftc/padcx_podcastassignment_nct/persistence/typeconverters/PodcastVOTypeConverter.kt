package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.PodcastVO

/*
class PodcastVOTypeConverter {
    @TypeConverter
    fun toString(podcastVO:PodcastVO):String {
        return Gson().toJson(podcastVO)
    }
    @TypeConverter
    fun toPodcastVO(podcastVOJsonString:String):PodcastVO {
        val podcastType = object :TypeToken<PodcastVO>(){}.type
        return Gson().fromJson(podcastVOJsonString,podcastType)
    }
}*/
