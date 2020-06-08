package com.saarthiapp.android.adapter.feed

import android.content.Context
import android.util.Log
import androidx.appcompat.widget.PopupMenu
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

        postImageBinding.imgMoreOptionImageHolder.setOnClickListener{
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
}