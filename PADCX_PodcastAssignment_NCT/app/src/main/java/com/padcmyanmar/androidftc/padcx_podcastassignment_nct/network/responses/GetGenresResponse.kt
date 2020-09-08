package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.persistence.typeconverters.GenresVOListTypeConverter

@Entity(tableName = "genres")
@TypeConverters(GenresVOListTypeConverter::class)
data class GetGenresResponse(
    @PrimaryKey
    val id : Int = 1,
    @SerializedName("genres") val genres : ArrayList<GenreVO>? = null
) {
    fun isResponseOk() = (genres != null)
}