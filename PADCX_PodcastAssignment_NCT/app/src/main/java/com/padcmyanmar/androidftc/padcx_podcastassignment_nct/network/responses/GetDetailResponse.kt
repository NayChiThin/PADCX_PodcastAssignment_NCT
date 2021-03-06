package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.PodcastVO

@Entity(tableName = "detail")
data class GetDetailResponse(
    @SerializedName("maybe_audio_invalid") var maybeAudioInvalid : Boolean = false,
    @SerializedName("pub_date_ms") var pubDateMs : Long = 0,
    @SerializedName("audio") var audio : String = "",
    @SerializedName("listennotes_edit_url") var listenNotesEditUrl : String = "",
    @SerializedName("image") var image : String = "",
    @SerializedName("thumbnail") var thumbnail : String = "",
    @SerializedName("description") var description : String = "",
    @SerializedName("title") var title : String = "",
    @SerializedName("explicit_content") var explicitContent : Boolean = false,
    @SerializedName("listennotes_url") var listenNotesUrl : String = "",
    @SerializedName("audio_length_sec") var audioLengthSec : Long = 0,
    @PrimaryKey
    @SerializedName("id") var id : String = "",
    @SerializedName("link") var link : String = "",
    @Embedded(prefix = "podcast")
    @SerializedName("podcast") var podcast: PodcastVO? = null
) {
}