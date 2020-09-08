package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.text.parseAsHtml
import com.bumptech.glide.Glide
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import kotlinx.android.synthetic.main.viewpod_show_item.view.*

class ShowItemViewPod @JvmOverloads constructor(
    context: Context, attrs:AttributeSet?=null,defStyleAttr:Int = 0
):LinearLayout(context,attrs,defStyleAttr){
    private var mDelegate : Delegate? = null
    private var showId : String = ""
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun bindData(data:DownloadVO) {
        showId = data.id
        tvPodcastTitle.text = data.title
        tvDescription.text = data.description.parseAsHtml()
        Glide.with(context)
            .load(data.image)
            .into(ivPodcast)
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
        fun onTapShowItem(id:String)
    }
}