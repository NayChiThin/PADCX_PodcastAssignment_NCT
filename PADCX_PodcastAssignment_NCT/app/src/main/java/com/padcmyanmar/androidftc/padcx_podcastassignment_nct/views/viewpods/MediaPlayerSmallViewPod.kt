package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.viewpod_media_player_small.view.*

class MediaPlayerSmallViewPod @JvmOverloads constructor(
    context: Context,attrs:AttributeSet?=null,defStyleAttr:Int = 0
    ) :RelativeLayout(context,attrs,defStyleAttr){
    private var mDelegate : Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun bindData(currentTime:String,totalTime:String) {
        tvCurrentTime.text = currentTime
        tvTotalTime.text = totalTime
    }
    fun setUpListener() {
        fabPlay.setOnClickListener {
            mDelegate?.onTapPlay()
        }
    }
    fun setUpDelegate(delegate: Delegate) {
        mDelegate = delegate
    }
    interface Delegate {
        fun onTapPlay()
    }
}