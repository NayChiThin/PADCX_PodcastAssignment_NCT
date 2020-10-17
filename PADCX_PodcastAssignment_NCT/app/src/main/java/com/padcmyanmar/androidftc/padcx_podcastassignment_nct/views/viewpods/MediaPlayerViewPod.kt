package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.views.viewpods

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.util.Log
import androidx.core.text.parseAsHtml
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.PodcastApp.Companion.simpleExoPlayer
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.data.vos.DataVO
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.network.responses.GetRandomEpisodeResponse
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils.PlaybackStateListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.custom_player.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class MediaPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs:AttributeSet?=null,defStyleAttr:Int=0
):PlayerControlView(context,attrs,defStyleAttr){

    private var playWhenReady : Boolean = false
    private var currentWindow : Int = 0
    private var audioLink : String = ""
    private var playbackPosition : Long = 0
    private val playbackStateListener = PlaybackStateListener()

    override fun onFinishInflate() {
        super.onFinishInflate()
        initializePlayer()
    }
    fun bindData(randomEpisode:DataVO) {
        tvPodcastTitle.text = randomEpisode.title
        tvPodcastDescription.text = randomEpisode.description.parseAsHtml()
        Glide.with(context)
            .load(randomEpisode.image)
            .into(ivPodCast)
//        audioLink = randomEpisode.link
        audioLink = "https://chtbl.com/track/24EG4/traffic.libsyn.com/secure/mfceoproject/Ep_55_-_7.10.2020_Pt2.mp3"

        val uri: Uri = Uri.parse(audioLink)
        val mediaSource : MediaSource = buildMediaSource(uri)
        simpleExoPlayer?.prepare(mediaSource)
        simpleExoPlayer?.seekTo(currentWindow,playbackPosition)
        simpleExoPlayer?.playWhenReady = playWhenReady
        simpleExoPlayer?.addListener(playbackStateListener)
    }

    private fun initializePlayer() {
        if(simpleExoPlayer==null) {

            simpleExoPlayer = SimpleExoPlayer.Builder(context).build()
        }
        viewpodMediaPlayer.player = simpleExoPlayer

    }

    private fun buildMediaSource(uri: Uri) : MediaSource {
        val dataSourceFactory : DataSource.Factory = DefaultDataSourceFactory(context,"podcast-app")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(uri)
    }

    private fun releasePlayer() {
        if(simpleExoPlayer!= null) {
            playWhenReady = simpleExoPlayer!!.playWhenReady
            playbackPosition = simpleExoPlayer!!.currentPosition
            currentWindow = simpleExoPlayer!!.currentWindowIndex
            simpleExoPlayer?.removeListener(playbackStateListener)
            simpleExoPlayer?.release()
            simpleExoPlayer = null
        }
    }
    fun onDestroy() {
        releasePlayer()
    }


}