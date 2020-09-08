package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.shared.mvp.views.BaseView

interface DownloadView : BaseView {
    fun navigateToDetails(id:String)
    fun navigateToHome()
    fun displayDownloadList(episodes:List<DownloadVO>)
}