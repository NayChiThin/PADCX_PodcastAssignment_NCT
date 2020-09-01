package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padcmyanmar.androidftc.shared.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>:BasePresenter<T>,ViewModel() {
    var mView : T? = null
    override fun initPresenter(view: T) {
        mView = view
    }
}