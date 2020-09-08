package com.padcmyanmar.androidftc.shared.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.androidftc.shared.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>(){
    var mData:MutableList<W> = arrayListOf()
    override fun getItemCount(): Int {
        return mData.size
    }
    fun setNewData(data:MutableList<W>) {
        mData = data
        notifyDataSetChanged()
    }

}