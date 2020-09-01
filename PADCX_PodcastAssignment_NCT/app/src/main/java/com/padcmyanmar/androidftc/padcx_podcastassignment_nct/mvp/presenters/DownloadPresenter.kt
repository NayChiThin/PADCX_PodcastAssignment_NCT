package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.ShowItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DownloadView

interface DownloadPresenter:BasePresenter<DownloadView>,ShowItemDelegate {
    fun onTapBack()
}