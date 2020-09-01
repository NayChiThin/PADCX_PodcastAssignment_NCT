package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.viewpod_media_player.view.*

class MediaPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs:AttributeSet?=null,defStyleAttr:Int=0
):RelativeLayout(context,attrs,defStyleAttr){
    private var mDelegate : Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun setUpListener() {
        fabPlay.setOnClickListener {
            mDelegate?.onTapPlay()
        }
    }
    fun bindData(title:String,description:String,remainTime:String,image:String) {
        tvPodcastTitle.text = title
        tvPodcastDescription.text = description
        tvRemainTime.text = remainTime
        Glide.with(context)
            .load(image)
            .into(ivPodCast)
    }
    fun setUpDelegate(delegate: Delegate) {
        mDelegate = delegate
    }
    interface Delegate {
        fun onTapPlay()
    }
}