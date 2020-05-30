package com.saarthiapp.android.adapter.feed

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.saarthiapp.android.databinding.FeedVideoPostLayoutBinding
import com.saarthiapp.android.model.feed.FeedPost

class RVVideoViewHolder(val videoPostBinding:FeedVideoPostLayoutBinding) : RecyclerView.ViewHolder(videoPostBinding.root) {

    fun bindVideoData(postData:FeedPost){
        val videoUri = Uri.parse(postData.mediaContent)
     videoPostBinding.exoPlayerPostFeed.setVideoURI(videoUri)
//        videoPostBinding.exoPlayerPostFeed.start()
    }
}