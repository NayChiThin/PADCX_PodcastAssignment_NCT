package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModel
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModelImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DetailView
import com.padcmyanmar.androidftc.shared.mvp.presenters.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {
    var mPodcastModel : PodcastModel = PodcastModelImpl
    private lateinit var lifecycleOwner: LifecycleOwner
    override fun onUiReady(lifecycleOwner: LifecycleOwner,id:String) {
        this.lifecycleOwner = lifecycleOwner

        id.let {
            mPodcastModel.getDetailById(it)
                .observe(lifecycleOwner, Observer {
                    it?.let {
                        mView?.displayDetail(it)
                    }
                })
        }
    }

    override fun onUiReadyFromDownload(lifecycleOwner: LifecycleOwner, id: String) {
        this.lifecycleOwner = lifecycleOwner

        mPodcastModel.getDownloadEpisodeByIdFromDb(id)
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayDetailDownload(it)
                }
            })
    }

    override fun getGenreName(genreId: Int):String {
        return mPodcastModel.getGenreNameById(genreId)
    }


}