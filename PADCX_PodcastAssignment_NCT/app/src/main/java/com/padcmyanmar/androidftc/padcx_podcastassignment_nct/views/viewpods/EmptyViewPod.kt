package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.viewpod_empty.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context,attrs:AttributeSet?=null,defStyleAttr:Int =0
) :RelativeLayout(context, attrs, defStyleAttr){
    private var mDelegate : Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun setUpListener() {
        btnFindNew.setOnClickListener {
            mDelegate?.onTapFindNew()
        }
        btnReload.setOnClickListener {
            mDelegate?.onTapReload()
        }
    }
    fun setUpDelegate(delegate: Delegate) {
        mDelegate = delegate
    }
    interface Delegate {
        fun onTapFindNew()
        fun onTapReload()
    }
}