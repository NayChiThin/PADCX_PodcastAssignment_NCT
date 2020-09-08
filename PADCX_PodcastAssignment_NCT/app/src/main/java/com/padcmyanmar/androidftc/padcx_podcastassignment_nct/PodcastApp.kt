package com.padcmyanmar.androidftc.padcx_podcastassignment_nct

import android.app.Application
import com.google.android.exoplayer2.SimpleExoPlayer
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.models.PodcastModelImpl

class PodcastApp:Application() {
    companion object {
        var simpleExoPlayer : SimpleExoPlayer? = null
        var simpleExoPlayerDetail : SimpleExoPlayer? = null
    }
    override fun onCreate() {
        super.onCreate()
        PodcastModelImpl.initDatabase(applicationContext)
        simpleExoPlayer = SimpleExoPlayer.Builder(applicationContext).build()
        simpleExoPlayerDetail = SimpleExoPlayer.Builder(applicationContext).build()
    }
}