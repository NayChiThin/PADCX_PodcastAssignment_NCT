package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetRandomEpisodeResponse

interface FirebaseApi {
    fun getGenres(onSuccess:(genresList:List<GenreVO>)->Unit,onFailure: (String) -> Unit)
    fun getEpisodes(onSucess:(episodeList:List<DataVO>)->Unit,onFailure: (String) -> Unit)
}