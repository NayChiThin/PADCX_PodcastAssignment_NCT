package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.viewpod_podcast_item.view.*

class PodcastItemViewPod @JvmOverloads constructor(
    context: Context,attrs:AttributeSet?=null,defStyleAttr:Int = 0
):LinearLayout(context, attrs, defStyleAttr){
    private var mDelegate : Delegate? = null
    private var podcastId : Int = 0
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
            mDelegate?.onTapDownload(podcastId)
        }
        rlCard.setOnClickListener {
            mDelegate?.onTapPodcastItem(podcastId)
        }
    }
    fun setUpDelegate(delegate:Delegate) {
        mDelegate = delegate
    }
    fun bindData() {
        /*Glide.with(context)
            .load("")
            .into(ivPodcast)
        tvPodcastTitle.text = ""
        tvPodcastCategory.text = ""
        progressListening.setBarPercentage(0f)
        tvRemainTime.text = ""*/
    }
    interface Delegate {
        fun onTapPodcastItem(podcastId:Int)
        fun onTapDownload(podcastId: Int)
    }
}