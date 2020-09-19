package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModel
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModelImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DownloadView
import com.padcmyanmar.androidftc.shared.mvp.presenters.AbstractBasePresenter

class DownloadPresenterImpl : DownloadPresenter, AbstractBasePresenter<DownloadView>() {
    var mPodcastModel : PodcastModel = PodcastModelImpl
    private lateinit var lifecycleOwner: LifecycleOwner
    override fun onTapBack() {
        mView?.navigateToHome()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner

        loadDownloadsFromDb()
    }

    private fun loadDownloadsFromDb() {
        mPodcastModel.getDownloadEpisodesFromDb()
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayDownloadList(it)
                }
            })
    }

    override fun onTapShowItem(showId: String) {
        mView?.navigateToDetails(showId)
    }

    override fun onTapFindNew() {
        mView?.navigateToHome()
    }

    override fun onTapReload() {
        loadDownloadsFromDb()
    }
}