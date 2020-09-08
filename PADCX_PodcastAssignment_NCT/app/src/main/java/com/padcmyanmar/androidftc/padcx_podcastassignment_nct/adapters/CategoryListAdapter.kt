package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.CategoryItemDelegate
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetGenresResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders.BaseCategoryListViewHolder
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders.CategoryListViewHolder
import com.padcmyanmar.androidftc.shared.adapters.BaseRecyclerAdapter

class CategoryListAdapter(delegate:CategoryItemDelegate)
    :
    BaseRecyclerAdapter<BaseCategoryListViewHolder,GenreVO>(){
    val mDelegate :CategoryItemDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseCategoryListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_list_items,parent,false)
        return CategoryListViewHolder(
            view,
            mDelegate
        )
    }

    override fun onBindViewHolder(holder: BaseCategoryListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}