package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders

import android.view.View
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.CategoryItemDelegate

class CategoryListViewHolder(itemView:View,delegate:CategoryItemDelegate)
    :BaseCategoryListViewHolder(itemView){
    init {
        itemView.setOnClickListener {
            delegate.onTapCategory()
        }
    }
    override fun bindData() {

    }
}