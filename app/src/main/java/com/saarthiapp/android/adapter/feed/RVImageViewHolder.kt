package com.saarthiapp.android.adapter.feed

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FeedImagePostLayoutBinding
import com.saarthiapp.android.model.feed.FeedPost

class RVImageViewHolder(val mCtx:Context, val postImageBinding:FeedImagePostLayoutBinding) : RecyclerView.ViewHolder(postImageBinding.root) {

    fun bindData(postData: FeedPost){
//        postImageBinding.setVariable(BR.)
        postImageBinding.tvPostImageUsername.text = postData.postName
        postImageBinding.tvPostImageLocation.text = postData.postLocation
        Glide.with(mCtx)
            .load(postData.mediaContent)
            .placeholder(R.drawable.post_image)
            .into(postImageBinding.imgPostFeeds)
    }
}