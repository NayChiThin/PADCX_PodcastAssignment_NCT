package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.text.parseAsHtml
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.DetailPresenter
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.presenters.DetailPresenterImpl
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.mvp.views.DetailView
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetDetailResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.PODCAST_DOWNLOAD_EXTRA
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.PODCAST_ID_EXTRA
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods.MediaPlayerSmallViewPod
import com.padcmyanmar.androidftc.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.ivPodcast
import kotlinx.android.synthetic.main.activity_detail.tvPodcastTitle
import kotlinx.android.synthetic.main.viewpod_podcast_item.*

class DetailActivity : BaseActivity(),DetailView {
    private lateinit var mDetailPresenter : DetailPresenter
    private lateinit var mMediaPlayerSmallViewPod: MediaPlayerSmallViewPod
    private var id : String = ""
    private var idDownload : String = ""
    companion object {
        fun newIntent(context: Context?,podcastId:String ) : Intent {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(PODCAST_ID_EXTRA,podcastId)
            return intent
        }
        fun newIntentFromDownload(context: Context?,podcastId:String) : Intent {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(PODCAST_DOWNLOAD_EXTRA,podcastId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        id = intent.getStringExtra(PODCAST_ID_EXTRA)?:""
        idDownload = intent.getStringExtra(PODCAST_DOWNLOAD_EXTRA)?:""

        setUpPresenter()
        setUpViewPod()

        if(idDownload=="") {
            mDetailPresenter.onUiReady(this,id)
        }else {
            mDetailPresenter.onUiReady(this,idDownload)
        }
    }

    override fun displayDetail(detail: DataVO) {
//        val genreId = detail.podcast?.genreIds?.first() ?: 0
        bindData(detail.image,detail.title,detail.description,detail.audioLengthSec.toLong(),detail.link,144)
    }

    override fun displayDetailDownload(detail: DownloadVO) {
        bindData(detail.image,detail.title,detail.description,detail.audioLengthSec,detail.audio,detail.genre)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayerSmallViewPod.onDestroy()
    }

    private fun setUpPresenter() {
        mDetailPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }
    private fun setUpViewPod() {
        mMediaPlayerSmallViewPod = viewpodMediaPlayerSmall as MediaPlayerSmallViewPod
    }
    private fun bindData(image:String,title:String,description:String,time:Long,link:String,genreId:Int){
        Glide.with(this)
            .load(image)
            .into(ivPodcast)
        tvPodcastTitle.text = title
        tvTime.text = ((time)/60f).toString()
        tvPodcastDescription.text = description.parseAsHtml()
        val genreName = mDetailPresenter.getGenreName(genreId)
        tvPodcastGenre.text = genreName
        when(genreName) {
            "Web Design" -> tvPodcastGenre.setBackgroundResource(R.drawable.rounded_textview_yellow)
            "Art Design" -> tvPodcastGenre.setBackgroundResource(R.drawable.rounded_textview_blue)
            "Mobile Design" -> tvPodcastGenre.setBackgroundResource(R.drawable.rounded_textview_purple)
            "Ui Design" -> tvPodcastGenre.setBackgroundResource(R.drawable.rounded_textview_purple)
            "Desktop Design" -> tvPodcastGenre.setBackgroundResource(R.drawable.rounded_textview_blue)
        }
        mMediaPlayerSmallViewPod.bindData(link)
    }
}
