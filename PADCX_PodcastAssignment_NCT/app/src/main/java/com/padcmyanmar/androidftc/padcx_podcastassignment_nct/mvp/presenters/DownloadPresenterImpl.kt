package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DownloadView

class DownloadPresenterImpl : DownloadPresenter,AbstractBasePresenter<DownloadView>() {
    override fun onTapBack() {
        mView?.navigateToHome()
    }

    override fun onTapShowItem(showId: Int) {
        mView?.navigateToDetails(showId)
    }
}