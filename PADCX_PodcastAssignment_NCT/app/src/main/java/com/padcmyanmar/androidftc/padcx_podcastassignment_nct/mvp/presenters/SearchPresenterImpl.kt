package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModel
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModelImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.SearchView
import com.padcmyanmar.androidftc.shared.mvp.presenters.AbstractBasePresenter

class SearchPresenterImpl:SearchPresenter, AbstractBasePresenter<SearchView>() {
    private var mPodcastModel : PodcastModel = PodcastModelImpl
    private lateinit var lifecycleOwner: LifecycleOwner
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
        loadGenresFromApi()
        loadGenresFromDb()
    }

    override fun onTapCategory() {
        mView?.navigateToHome()
    }
    private fun loadGenresFromApi() {
        mPodcastModel.getGenresFromApi(
            onSuccess = {},
            onFailure = {}
        )
    }
    private fun loadGenresFromDb() {
        mPodcastModel.getGenresFromDb()
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayGenres(it)
                }
            })
    }
}