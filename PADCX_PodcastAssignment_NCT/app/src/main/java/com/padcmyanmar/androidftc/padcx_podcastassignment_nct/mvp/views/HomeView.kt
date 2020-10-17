package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views

import android.content.Context
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetPlaylistInfoResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetRandomEpisodeResponse
import com.padcmyanmar.androidftc.shared.mvp.views.BaseView

interface HomeView : BaseView {
    fun navigateToDetails(podcastId:String)
    fun displayRandomEpisode(randomEpisode:DataVO)
    fun displayUpNextEpisodes(upnextEpisodes:List<DataVO>)
    fun downloadEpisode(context: Context,data:DataVO?)
}