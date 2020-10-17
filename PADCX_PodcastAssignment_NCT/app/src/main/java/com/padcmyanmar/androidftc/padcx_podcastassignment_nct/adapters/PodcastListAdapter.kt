package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.ItemVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.PodcastItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders.BasePodcastListViewHolder
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders.PodcastListViewHolder
import com.padcmyanmar.androidftc.shared.adapters.BaseRecyclerAdapter

class PodcastListAdapter(delegate:PodcastItemDelegate)
    :
    BaseRecyclerAdapter<BasePodcastListViewHolder,DataVO>(){
    val mDelegate : PodcastItemDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePodcastListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.podcast_list_items,parent,false)
        return PodcastListViewHolder(
            view,
            mDelegate
        )
    }

    override fun onBindViewHolder(holder: BasePodcastListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}