package com.padcmyanmar.androidftc.shared.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//    var mData: T? = null
    abstract fun bindData()
}