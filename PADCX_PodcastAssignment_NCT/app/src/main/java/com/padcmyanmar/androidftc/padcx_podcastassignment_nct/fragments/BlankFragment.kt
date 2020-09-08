package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import kotlinx.android.synthetic.main.fragment_blank.*

/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment(),Player.EventListener {

    private lateinit var simpleExoPlayer : SimpleExoPlayer
    private var playbackPosition : Long = 0
    private var mp4Url = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"
    private val dashUrl = "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_uhd.mpd"
    private val urlList = listOf(mp4Url to "default", dashUrl to "dash")
    private var playWhenReady = false
    private var currentWindow = 0
    private var playBackPosition:Long = 0
    private val dataSourceFactory : DataSource.Factory by lazy {
        DefaultDataSourceFactory(this.context,"exoplayer-sample")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    override fun onStart() {
        super.onStart()
//        initializePlayer()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
//        releasePlayer()
    }
/*
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        if(playbackState==Player.STATE_BUFFERING) {

        }else if(playbackState==Player.STATE_READY || playbackState==Player.STATE_ENDED) {

        }
    }
    override fun onPlayerError(error: ExoPlaybackException) {

    }
    private fun initializePlayer() {
        simpleExoPlayer = SimpleExoPlayer.Builder(requireContext()).build()
        val randomUrl = urlList.random()
        preparePlayer(randomUrl.first,randomUrl.second)
        exoplayerView.player = simpleExoPlayer
        simpleExoPlayer.seekTo(playbackPosition)
        simpleExoPlayer.playWhenReady = false
        simpleExoPlayer.addListener(this)
    }
    private fun preparePlayer(videoUrl:String,type:String) {
        val uri = Uri.parse(videoUrl)
        val mediaSource = buildMediaSource(uri,type)
        simpleExoPlayer.prepare(mediaSource)
    }
    private fun buildMediaSource(uri:Uri,type:String):MediaSource {
        return if(type=="dash") {
            DashMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        }else {
            ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
        }
    }
    private fun releasePlayer() {
        if(simpleExoPlayer!=null) {
            playWhenReady = simpleExoPlayer.playWhenReady
            playbackPosition = simpleExoPlayer.currentPosition
            currentWindow = simpleExoPlayer.currentWindowIndex
            simpleExoPlayer.release()
        }
    }*/

}
