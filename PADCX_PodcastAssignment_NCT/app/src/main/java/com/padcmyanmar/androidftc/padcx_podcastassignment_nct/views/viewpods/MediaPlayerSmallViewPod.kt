package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.PodcastApp.Companion.simpleExoPlayerDetail
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.PlaybackStateListener
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.custom_player_small.view.*

class MediaPlayerSmallViewPod @JvmOverloads constructor(
    context: Context,attrs:AttributeSet?=null,defStyleAttr:Int = 0
    ) :PlayerControlView(context,attrs,defStyleAttr){

    private var playWhenReady : Boolean = false
    private var currentWindow : Int = 0
    private var audioLink : String = ""
    private var playbackPosition : Long = 0
    private val playbackStateListener = PlaybackStateListener()

    override fun onFinishInflate() {
        super.onFinishInflate()
        initailizePlayer()
    }
    private fun initailizePlayer() {
        if(simpleExoPlayerDetail==null) {

            simpleExoPlayerDetail = SimpleExoPlayer.Builder(context).build()
        }
        viewpodMediaPlayerSmall.player = simpleExoPlayerDetail

    }
    fun bindData(link:String) {
//        audioLink = link
        audioLink = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"
        val uri: Uri = Uri.parse(audioLink)
        val mediaSource : MediaSource = buildMediaSource(uri)
        simpleExoPlayerDetail?.prepare(mediaSource)
        simpleExoPlayerDetail?.seekTo(currentWindow,playbackPosition)
        simpleExoPlayerDetail?.playWhenReady = playWhenReady
        simpleExoPlayerDetail?.addListener(playbackStateListener)
    }
    private fun buildMediaSource(uri: Uri) : MediaSource {
        val dataSourceFactory : DataSource.Factory = DefaultDataSourceFactory(context,"podcast-app")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(uri)
    }

    private fun releasePlayer() {
        if(simpleExoPlayerDetail!= null) {
            playWhenReady = simpleExoPlayerDetail!!.playWhenReady
            playbackPosition = simpleExoPlayerDetail!!.currentPosition
            currentWindow = simpleExoPlayerDetail!!.currentWindowIndex
            simpleExoPlayerDetail?.removeListener(playbackStateListener)
            simpleExoPlayerDetail?.release()
            simpleExoPlayerDetail = null
        }
    }
    fun onDestroy() {
//        releasePlayer()
    }
}