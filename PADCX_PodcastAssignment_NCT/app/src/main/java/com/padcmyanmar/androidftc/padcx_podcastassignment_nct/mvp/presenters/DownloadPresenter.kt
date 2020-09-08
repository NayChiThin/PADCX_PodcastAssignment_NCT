package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.ShowItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DownloadView
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods.EmptyViewPod

interface DownloadPresenter:BasePresenter<DownloadView>,ShowItemDelegate,EmptyViewPod.Delegate {
    fun onTapBack()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}