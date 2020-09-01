package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.CategoryItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.SearchView

interface SearchPresenter : BasePresenter<SearchView>,CategoryItemDelegate {
}