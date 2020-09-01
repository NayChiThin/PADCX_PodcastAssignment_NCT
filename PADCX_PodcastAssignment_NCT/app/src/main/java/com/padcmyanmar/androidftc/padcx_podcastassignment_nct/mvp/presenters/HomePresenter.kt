package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.PodcastItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.HomeView

interface HomePresenter :BasePresenter<HomeView>,PodcastItemDelegate{
}