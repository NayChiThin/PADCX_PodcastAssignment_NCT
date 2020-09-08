package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO

class ItemVOListTypeConverter {
    @TypeConverter
    fun toString(itemVOList:ArrayList<ItemVO>) : String {
        return Gson().toJson(itemVOList)
    }
    @TypeConverter
    fun toItemVOList(itemsVOListJsonString:String):ArrayList<ItemVO> {
        val itemVoListType = object : TypeToken<ArrayList<ItemVO>>(){}.type
        return Gson().fromJson(itemsVOListJsonString,itemVoListType)
    }
}