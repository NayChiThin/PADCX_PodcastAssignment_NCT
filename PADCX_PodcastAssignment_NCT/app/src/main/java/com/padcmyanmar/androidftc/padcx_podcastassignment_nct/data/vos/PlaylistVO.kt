package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PlaylistVO(
    @SerializedName("episode_count") var episodeCount : Int = 0,
    @SerializedName("podcast_count") var podcastCount : Int = 0,
    @SerializedName("id") var id : String = "",
    @SerializedName("name") var name : String = "",
    @SerializedName("description") var description : String = "",
    @SerializedName("image") var image : String = "",
    @SerializedName("thumbnail") var thumbnail : String = "",
    @SerializedName("listennotes_url") var listenNotesUrl : String = "",
    @SerializedName("visibility") var visibility : String = "",
    @SerializedName("last_timestamp_ms") var lastTimeStampMs : Long = 0
) {
}