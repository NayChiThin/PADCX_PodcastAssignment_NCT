package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders

import android.view.View
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
    override fun bindData() {
        //bind data to viewpod
        mPodcastItemViewPod.bindData()
        mPodcastItemViewPod.setUpDelegate(delegate)
    }

}