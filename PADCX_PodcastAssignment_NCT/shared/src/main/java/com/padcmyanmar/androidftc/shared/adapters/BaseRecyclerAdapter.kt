package com.padcmyanmar.androidftc.shared.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.androidftc.shared.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T: BaseViewHolder> : RecyclerView.Adapter<T>(){
    var mData:MutableList<String> = arrayListOf<String>()
    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData()
    }
}