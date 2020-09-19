package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.CategoryItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.SearchView
import com.padcmyanmar.androidftc.shared.mvp.presenters.BasePresenter

interface SearchPresenter : BasePresenter<SearchView>,CategoryItemDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}