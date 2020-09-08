package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters.DownloadVOListTypeConverter


@Entity(tableName = "download")
data class DownloadVO(
    @PrimaryKey
    var id: String = "",
    var title : String = "",
    var description: String = "",
    var audio : String = "",
    var audioLengthSec : Long = 0,
    var image : String = "",
    var genre : Int = 0
) {
}
