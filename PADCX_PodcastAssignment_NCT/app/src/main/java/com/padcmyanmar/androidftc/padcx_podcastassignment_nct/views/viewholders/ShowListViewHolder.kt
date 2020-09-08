package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders

import android.view.View
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DownloadVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.ShowItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods.ShowItemViewPod
import kotlinx.android.synthetic.main.shows_list_items.view.*

class ShowListViewHolder(itemView: View, private val delegate:ShowItemDelegate)
    :BaseShowListViewHolder(itemView) {
    private val mShowItemViewPod = itemView.viewpodShowItem as ShowItemViewPod
    init {
        itemView.setOnClickListener {
           /* mData?.let {
                delegate.onTapShowItem(it.id)
            }*/
        }
    }
    override fun bindData(data: DownloadVO) {
        mData = data
        mShowItemViewPod.bindData(data)
        mShowItemViewPod.setUpDelegate(delegate)
    }
}