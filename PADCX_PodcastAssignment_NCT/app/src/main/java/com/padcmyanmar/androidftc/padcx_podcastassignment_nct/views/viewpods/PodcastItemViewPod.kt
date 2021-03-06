package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
import kotlinx.android.synthetic.main.viewpod_podcast_item.view.*

class PodcastItemViewPod @JvmOverloads constructor(
    context: Context,attrs:AttributeSet?=null,defStyleAttr:Int = 0
):LinearLayout(context, attrs, defStyleAttr){
    private var mDelegate : Delegate? = null
    private var podcastId : String = ""
    private var mData : DataVO? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun setUpListener() {
        ivPodcast.setOnClickListener {
            mDelegate?.onTapPodcastItem(podcastId)
        }
        tvPodcastTitle.setOnClickListener {
            mDelegate?.onTapPodcastItem(podcastId)
        }
        ivDownload.setOnClickListener {
            mDelegate?.onTapDownload(context,mData)
        }
        rlCard.setOnClickListener {
            mDelegate?.onTapPodcastItem(podcastId)
        }
    }
    fun setUpDelegate(delegate:Delegate) {
        mDelegate = delegate
    }
    @SuppressLint("SetTextI18n")
    fun bindData(data:DataVO) {
        mData = data
        podcastId = data.id?:""
        Glide.with(context)
            .load(data.image)
            .into(ivPodcast)
        tvPodcastTitle.text = data.title
        progressListening.setBarPercentage(0f)
        tvRemainTime.text = "${data.audioLengthSec.div(60)}min"
    }
    interface Delegate {
        fun onTapPodcastItem(podcastId:String)
        fun onTapDownload(context:Context,data:DataVO?)
    }
}