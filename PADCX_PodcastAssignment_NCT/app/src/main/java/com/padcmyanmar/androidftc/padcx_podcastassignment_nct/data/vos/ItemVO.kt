package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

data class ItemVO(
    @SerializedName("id") var id : Int = 0,
    @SerializedName("type") var type : String = "",
    @SerializedName("notes") var notes : String = "",
    @SerializedName("added_at_ms") var addedAtMs : Long = 0,
    @Embedded(prefix = "data")
    @SerializedName("data") var data : DataVO? = null
) {
}