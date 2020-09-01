package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.viewpod_show_item.view.*

class ShowItemViewPod @JvmOverloads constructor(
    context: Context, attrs:AttributeSet?=null,defStyleAttr:Int = 0
):LinearLayout(context,attrs,defStyleAttr){
    private var mDelegate : Delegate? = null
    private var showId : Int = 0
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun bindData() {
        /*tvPodcastTitle.text = ""
        tvDescription.text = ""
        tvPodcastCategory.text = ""
        Glide.with(context)
            .load("")
            .into(ivPodcast)*/
    }
    fun setUpListener() {
        showCard.setOnClickListener {
            mDelegate?.onTapShowItem(showId)
        }
    }
    fun setUpDelegate(delegate: Delegate) {
        mDelegate = delegate
    }
    interface Delegate {
        fun onTapShowItem(showId:Int)
    }
}