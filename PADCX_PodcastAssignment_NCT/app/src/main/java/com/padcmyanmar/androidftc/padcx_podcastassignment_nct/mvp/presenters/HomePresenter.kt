package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.PodcastItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.HomeView
import com.padcmyanmar.androidftc.shared.mvp.presenters.BasePresenter

interface HomePresenter : BasePresenter<HomeView>,PodcastItemDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun saveDownload(episode:DownloadVO)
    fun getGenreName(genreId:Int) : String
}