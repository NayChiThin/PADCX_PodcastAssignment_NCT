package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views

import com.padcmyanmar.androidftc.shared.mvp.views.BaseView

interface DownloadView : BaseView {
    fun navigateToDetails(podcastId:Int)
    fun navigateToHome()
}