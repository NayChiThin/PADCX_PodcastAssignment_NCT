package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetDetailResponse
import com.padcmyanmar.androidftc.shared.mvp.views.BaseView

interface DetailView : BaseView {
    fun displayDetail(detail:DataVO)
    fun displayDetailDownload(detail:DownloadVO)
}