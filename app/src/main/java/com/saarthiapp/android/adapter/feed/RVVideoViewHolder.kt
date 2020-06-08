package com.saarthiapp.android.adapter.feed

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.Player
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FeedVideoPostLayoutBinding
import com.saarthiapp.android.model.feed.FeedPost
import com.saarthiapp.android.ui.utils.exoplayer.PlayerStateCallback

class RVVideoViewHolder(val mCtx: Context, val videoPostBinding:FeedVideoPostLayoutBinding) : RecyclerView.ViewHolder(videoPostBinding.root), PlayerStateCallback {

    fun bindVideoData(postData:FeedPost){
        val videoUri = Uri.parse(postData.mediaContent)

        with(videoPostBinding) {
            url = postData.mediaContent
            callback = this@RVVideoViewHolder
            executePendingBindings()
        }
//     videoPostBinding.exoPlayerPostFeed.setVideoURI(videoUri)
//        videoPostBinding.exoPlayerPostFeed.start()

        videoPostBinding.imgMoreOptionVideoHolder.setOnClickListener{
            val popMenuImageHolder = PopupMenu(mCtx, it)
            popMenuImageHolder.inflate(R.menu.story_option_menu)
            popMenuImageHolder.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.editPostMenu -> {
                        Log.e("edit menu", " :: clicked")
                    }

                    R.id.deletePostMenu -> {
                        Log.e("delete menu", " :: clicked")
                    }
                }
                return@setOnMenuItemClickListener false
            }
            popMenuImageHolder.show()
        }
    }

    override fun onVideoDurationRetrieved(duration: Long, player: Player) {
        Log.e("onVideoDuratnRetrieved", " :: $duration :: ${player.bufferedPercentage}")
    }

    override fun onVideoBuffering(player: Player) {

    }

    override fun onStartedPlaying(player: Player) {

    }

    override fun onFinishedPlaying(player: Player) {

    }
}