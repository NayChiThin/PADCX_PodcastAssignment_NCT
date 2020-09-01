package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import com.padcmyanmar.androidftc.shared.mvp.views.BaseView

interface BasePresenter<T: BaseView> {
    fun initPresenter(view:T)
}