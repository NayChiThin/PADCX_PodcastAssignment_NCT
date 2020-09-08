package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.*

interface PodcastModel {
    fun getRandomEpisodeFromApi(onSuccess:()->Unit,onFailure:(String)->Unit)
    fun getRandomEpisodeFromDb() : LiveData<GetRandomEpisodeResponse>

    fun getGenresFromApi(onSuccess: () -> Unit,onFailure: (String) -> Unit)
    fun getGenresFromDb() : LiveData<GetGenresResponse>

    fun getPlaylistInfoFromApi(onSuccess: () -> Unit,onFailure: (String) -> Unit,id:String)
    fun getPlaylistInfoFromDb(id:String) : LiveData<GetPlaylistInfoResponse>

    fun getDetailById(id:String) : LiveData<GetDetailResponse>

    fun saveEpisodesIntoDb(episode:DownloadVO)
    fun getDownloadEpisodesFromDb() : LiveData<List<DownloadVO>>
    fun getDownloadEpisodeByIdFromDb(id:String) : LiveData<DownloadVO>

    fun getGenreNameById(genreId:Int) : String
}