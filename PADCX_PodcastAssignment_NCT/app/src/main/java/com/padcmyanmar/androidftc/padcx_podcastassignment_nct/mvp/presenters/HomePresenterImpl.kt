package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.HomeView

class HomePresenterImpl:HomePresenter,AbstractBasePresenter<HomeView>() {
    override fun onTapPodcastItem(podcastId: Int) {
        mView?.navigateToDetails(podcastId)
    }

    override fun onTapDownload(podcastId: Int) {

    }
}