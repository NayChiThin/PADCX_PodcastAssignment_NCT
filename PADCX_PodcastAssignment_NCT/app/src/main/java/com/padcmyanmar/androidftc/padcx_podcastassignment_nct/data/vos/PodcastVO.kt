package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters.GenreIdsListTypeConverter

@TypeConverters(GenreIdsListTypeConverter::class)
data class PodcastVO (
    @SerializedName("id") var id : String = "",
    @SerializedName("title") var title : String = "",
    @SerializedName("publisher") var publisher : String = "",
    @SerializedName("image") var image : String = "",
    @SerializedName("thumbnail") var thumbnail : String = "",
    @SerializedName("listennotes_url") var listenNotesUrl : String = "",
    @SerializedName("genre_ids") var genreIds : ArrayList<Int> = arrayListOf()
    )