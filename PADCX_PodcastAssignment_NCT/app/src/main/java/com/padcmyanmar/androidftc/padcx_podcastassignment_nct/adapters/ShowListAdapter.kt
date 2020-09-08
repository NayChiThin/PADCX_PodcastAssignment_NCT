package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.ShowItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders.BaseShowListViewHolder
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders.ShowListViewHolder
import com.padcmyanmar.androidftc.shared.adapters.BaseRecyclerAdapter

class ShowListAdapter(delegate:ShowItemDelegate) : BaseRecyclerAdapter<BaseShowListViewHolder,DownloadVO>() {
    private val mDelegate : ShowItemDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseShowListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shows_list_items,parent,false)
        return ShowListViewHolder(
            view,
            mDelegate
        )
    }

    override fun onBindViewHolder(holder: BaseShowListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}