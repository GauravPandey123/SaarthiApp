package com.saarthiapp.android.adapter.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FeedImagePostLayoutBinding
import com.saarthiapp.android.databinding.FeedVideoPostLayoutBinding
import com.saarthiapp.android.model.feed.FeedPost

class FeedPostAdapter(val mCtx:Context,
                      val feedPostList:ArrayList<FeedPost>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_IMAGE = 0
    private val TYPE_VIDEO = 1

    override fun getItemViewType(position: Int): Int {
        if(feedPostList[position].type.equals("image", true)){
            return TYPE_IMAGE
        }else{
            return TYPE_VIDEO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            TYPE_IMAGE -> {
                val imageFeedBinding:FeedImagePostLayoutBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(mCtx), R.layout.feed_image_post_layout, parent, false)
                return RVImageViewHolder(mCtx, imageFeedBinding)
            }

            else -> {
                val videoFeedBinding:FeedVideoPostLayoutBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(mCtx), R.layout.feed_video_post_layout, parent, false)
                return RVVideoViewHolder(mCtx, videoFeedBinding)
            }
        }
    }

    override fun getItemCount(): Int {
        return feedPostList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == TYPE_IMAGE){
            (holder as RVImageViewHolder).bindData(feedPostList[position])
        }else{
            (holder as RVVideoViewHolder).bindVideoData(feedPostList[position])
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {

        val position = holder.adapterPosition
        if(getItemViewType(position) == TYPE_IMAGE){
            (holder as RVImageViewHolder).bindData(feedPostList[position])
        }else{
            (holder as RVVideoViewHolder).bindVideoData(feedPostList[position])
        }
        /*if (feedPostList.get(position) != null) {
            feedPostList.get(position).getPlayer().release();
        }*/

        super.onViewRecycled(holder)
    }
}