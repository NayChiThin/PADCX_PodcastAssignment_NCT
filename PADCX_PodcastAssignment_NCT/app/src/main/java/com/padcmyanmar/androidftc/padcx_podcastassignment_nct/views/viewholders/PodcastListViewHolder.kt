package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders

import android.view.View
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.PodcastItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods.PodcastItemViewPod
import kotlinx.android.synthetic.main.podcast_list_items.view.*

class PodcastListViewHolder(itemView:View,private val delegate:PodcastItemDelegate)
    : BasePodcastListViewHolder(itemView){
    private val mPodcastItemViewPod = itemView.viewpodPodcastItem as PodcastItemViewPod
    init {
        itemView.setOnClickListener {
            /*mData?.let {
                delegate.onTapPodcastItem(it.id)
        }*/
        }
    }

    override fun bindData(data: DataVO) {
        mData = data
        mPodcastItemViewPod.bindData(data)
        mPodcastItemViewPod.setUpDelegate(delegate)
    }
}