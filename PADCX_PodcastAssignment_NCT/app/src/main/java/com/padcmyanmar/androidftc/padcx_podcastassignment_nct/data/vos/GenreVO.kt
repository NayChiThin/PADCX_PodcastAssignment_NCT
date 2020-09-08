package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genreList")
class GenreVO (
    @PrimaryKey
    @SerializedName("id") var id : Int = 0,
    @SerializedName("parent_id") var parentId : Int = 0,
    @SerializedName("name") var name: String = ""
)