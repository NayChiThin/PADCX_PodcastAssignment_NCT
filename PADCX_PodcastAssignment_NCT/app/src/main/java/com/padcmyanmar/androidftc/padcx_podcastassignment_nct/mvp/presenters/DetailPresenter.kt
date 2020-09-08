package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DetailView

interface DetailPresenter : BasePresenter<DetailView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner,id:String)
    fun onUiReadyFromDownload(lifecycleOwner: LifecycleOwner,id:String)
    fun getGenreName(genreId:Int) : String
}