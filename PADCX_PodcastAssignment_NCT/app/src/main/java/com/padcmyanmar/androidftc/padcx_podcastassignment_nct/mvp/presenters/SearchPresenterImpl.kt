package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.SearchView

class SearchPresenterImpl:SearchPresenter,AbstractBasePresenter<SearchView>() {
    override fun onTapCategory() {
        mView?.navigateToHome()
    }
}