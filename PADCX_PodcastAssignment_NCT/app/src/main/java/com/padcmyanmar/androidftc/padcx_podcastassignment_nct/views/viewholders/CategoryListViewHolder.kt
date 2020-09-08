package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewholders

import android.view.View
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.GenreVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.delegates.CategoryItemDelegate
import kotlinx.android.synthetic.main.categories_list_items.view.*

class CategoryListViewHolder(itemView:View,delegate:CategoryItemDelegate)
    :BaseCategoryListViewHolder(itemView){
    init {
        itemView.setOnClickListener {
            delegate.onTapCategory()
        }
    }
    override fun bindData(data:GenreVO) {
        mData = data
        itemView.tvCategory.text = data.name
    }
}