package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.PODCAST_ID_EXTRA

class DetailActivity : com.padcmyanmar.androidftc.shared.activities.BaseActivity() {
    companion object {
        fun newIntent(context: Context?,podcastId:Int ) : Intent {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(PODCAST_ID_EXTRA,podcastId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

    }

}
