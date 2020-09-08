package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetGenresResponse
import com.padcmyanmar.androidftc.shared.mvp.views.BaseView

interface SearchView : BaseView {
    fun navigateToHome()
    fun displayGenres(genres:GetGenresResponse)
}