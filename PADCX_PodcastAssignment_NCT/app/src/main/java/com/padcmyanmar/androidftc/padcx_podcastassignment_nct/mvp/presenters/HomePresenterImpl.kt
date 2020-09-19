package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModel
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModelImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.HomeView
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.EPISODE_ID
import com.padcmyanmar.androidftc.shared.mvp.presenters.AbstractBasePresenter


class HomePresenterImpl:HomePresenter, AbstractBasePresenter<HomeView>() {
    var mPodcastModel : PodcastModel = PodcastModelImpl
    private lateinit var lifecycleOwner: LifecycleOwner

    init {
        loadRandomEpisodeFromApi()
        loadPlaylistInfoFromApi(EPISODE_ID)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner

        loadRandomEpisodeFromDb()

        loadPlaylistInfoFromDb(EPISODE_ID)

    }

    override fun saveDownload(episode:DownloadVO) {
        saveToDb(episode)
    }

    override fun getGenreName(genreId: Int): String {
        return mPodcastModel.getGenreNameById(genreId)
    }

    override fun onTapPodcastItem(podcastId: String) {
        mView?.navigateToDetails(podcastId)
    }

    override fun onTapDownload(context:Context,data:ItemVO?) {
//        Log.d("Tapped Download:","tapped id : $downloadUrl")
        mView?.downloadEpisode(context,data)
    }

    private fun saveToDb(episode:DownloadVO) {
        mPodcastModel.saveEpisodesIntoDb(episode)
    }
    private fun loadRandomEpisodeFromApi() {
        mPodcastModel.getRandomEpisodeFromApi(
            onSuccess = {},
            onFailure = {}
        )
    }
    private fun loadRandomEpisodeFromDb() {
        mPodcastModel.getRandomEpisodeFromDb()
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayRandomEpisode(it)
                }
            })
    }
    private fun loadPlaylistInfoFromApi(id:String) {
        mPodcastModel.getPlaylistInfoFromApi(
            onSuccess = {},
            onFailure = {},
            id = id
        )
    }
    private fun loadPlaylistInfoFromDb(id:String) {
        mPodcastModel.getPlaylistInfoFromDb(id)
            .observe(lifecycleOwner, Observer {
                it?.let {
                    mView?.displayUpNextEpisodes(it)
                }
            })
    }
}