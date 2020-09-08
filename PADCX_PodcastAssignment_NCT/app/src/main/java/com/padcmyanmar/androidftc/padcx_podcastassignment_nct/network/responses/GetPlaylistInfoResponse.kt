package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters.ItemVOListTypeConverter

@Entity(tableName = "playlistInfo")
@TypeConverters(ItemVOListTypeConverter::class)
data class GetPlaylistInfoResponse(
    @PrimaryKey
    @SerializedName("id") var id : String = "",
    @SerializedName("name") var name : String = "",
    @SerializedName("description") var description : String = "",
    @SerializedName("image") var image : String = "",
    @SerializedName("thumbnail") var thumbnail : String = "",
    @SerializedName("listennotes_url") var listenNotesUrl : String = "",
    @SerializedName("visibility") var visibility : String = "",
    @SerializedName("last_timestamp_ms") var lastTimeStampMs : Long = 0,
    @SerializedName("total") var total : Long = 0,
    @SerializedName("type") var type : String = "",
    @SerializedName("items") var items : ArrayList<ItemVO>? = null
) {
}