package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.utils

import android.util.Log
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player

class PlaybackStateListener : Player.EventListener {
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        super.onPlayerStateChanged(playWhenReady, playbackState)
        var stateString: String = ""
        when (playbackState) {
            ExoPlayer.STATE_IDLE -> stateString = "ExoPlayer.STATE_IDLE - "
            ExoPlayer.STATE_BUFFERING -> stateString = "STATE_BUFFERING - "
            ExoPlayer.STATE_READY -> stateString = "STATE_READY - "
            ExoPlayer.STATE_ENDED -> stateString = "STATE_ENDED - "
            else -> stateString = "UNKNOWN_STATE"
        }
        Log.d("TAG-Listener : ", "changed state to $stateString playwhenready: $playWhenReady")
    }

    override fun onIsPlayingChanged(isPlaying: Boolean) {
        super.onIsPlayingChanged(isPlaying)
        if(isPlaying) {
            Log.d("TAG-IsPlaying",isPlaying.toString())
        }
    }

    override fun onPlayerError(error: ExoPlaybackException) {
        super.onPlayerError(error)
        Log.d("TAG-Error",error.message)
    }
}