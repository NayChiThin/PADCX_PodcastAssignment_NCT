package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
/*

class DataVOTypeConverter {
    @TypeConverter
    fun toString(itemVO:ItemVO):String {
        return Gson().toJson(itemVO)
    }
    @TypeConverter
    fun toItemvO(itemVOJSonString:String):ItemVO {
        val itemType = object : TypeToken<ItemVO>(){}.type
        return Gson().fromJson(itemVOJSonString,itemType)
    }
}*/
