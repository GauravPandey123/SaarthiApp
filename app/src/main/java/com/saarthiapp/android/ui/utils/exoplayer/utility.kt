package com.saarthiapp.android.ui.utils.exoplayer

import android.graphics.Color
import android.net.Uri
import android.util.Log
import androidx.databinding.BindingAdapter
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

@BindingAdapter("video_url", "on_state_change")
fun PlayerView.loadVideo(url: String?, callback: PlayerStateCallback) {
    if (url == null) return
    val player = ExoPlayerFactory.newSimpleInstance(
        context, DefaultRenderersFactory(context), DefaultTrackSelector(),
        DefaultLoadControl()
    )

    this.setShutterBackgroundColor(Color.TRANSPARENT)
    player.playWhenReady = false
    player.repeatMode = Player.REPEAT_MODE_OFF
    // When changing track, retain the latest frame instead of showing a black screen
    setKeepContentOnPlayerReset(true)
    // We'll show the controller
    this.useController = true
    // Provide url to load the video from here
    val mediaSource = ExtractorMediaSource.Factory(
        DefaultHttpDataSourceFactory("Demo")
    ).createMediaSource(Uri.parse(url))

    player.prepare(mediaSource)

    this.player = player

    this.player!!.addListener(object : Player.EventListener {

        override fun onPlayerError(error: ExoPlaybackException?) {
            super.onPlayerError(error)
            Log.e("video load error", " :: Oops! Error occurred while playing media.")
        }

        override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
            super.onPlayerStateChanged(playWhenReady, playbackState)

            if (playbackState == Player.STATE_BUFFERING)
                callback.onVideoBuffering(player) // Buffering.. set progress bar visible here
            if (playbackState == Player.STATE_READY){
                // [PlayerView] has fetched the video duration so this is the block to hide the buffering progress bar
                callback.onVideoDurationRetrieved(this@loadVideo.player.duration, player)
            }
            if (playbackState == Player.STATE_READY && player.playWhenReady){
                // [PlayerView] has started playing/resumed the video
                callback.onStartedPlaying(player)
            }
            if(playbackState == Player.STATE_ENDED){
                callback.onFinishedPlaying(player)
            }
        }
    })
}