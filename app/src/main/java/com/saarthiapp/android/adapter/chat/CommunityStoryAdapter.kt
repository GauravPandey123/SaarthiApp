package com.saarthiapp.android.adapter.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.saarthiapp.android.BR
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ChatImageOverlapLayoutBinding
import com.saarthiapp.android.databinding.ChatMemberImageLayoutBinding
import com.saarthiapp.android.databinding.CommunityStoryItemLayoutBinding

class CommunityStoryAdapter(val mCtx:Context, val circulatImageList:List<String>)
    : RecyclerView.Adapter<CommunityStoryAdapter.MemberImageViewVH>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemberImageViewVH {
        val commStoryItemBinding:CommunityStoryItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mCtx),
        R.layout.community_story_item_layout, parent, false)
        return MemberImageViewVH(commStoryItemBinding)
    }

    override fun getItemCount(): Int {
       return circulatImageList.size
    }

    override fun onBindViewHolder(holder: MemberImageViewVH, position: Int) {
        holder.bindItemView(circulatImageList[position])
    }

    class MemberImageViewVH(val commStoryItemBinding:CommunityStoryItemLayoutBinding)
        : RecyclerView.ViewHolder(commStoryItemBinding.root) {

        fun bindItemView(imgItem:String){
            commStoryItemBinding.setVariable(BR.communityStoryString, imgItem)
            commStoryItemBinding.executePendingBindings()
        }
    }

}