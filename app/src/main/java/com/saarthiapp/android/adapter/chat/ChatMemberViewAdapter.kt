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

class ChatMemberViewAdapter(val mCtx:Context, val circulatImageList:List<String>)
    : RecyclerView.Adapter<ChatMemberViewAdapter.MemberImageViewVH>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemberImageViewVH {
        val memberItemBinding:ChatMemberImageLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mCtx),
        R.layout.chat_member_image_layout, parent, false)
        return MemberImageViewVH(memberItemBinding)
    }

    override fun getItemCount(): Int {
       return circulatImageList.size
    }

    override fun onBindViewHolder(holder: MemberImageViewVH, position: Int) {
        holder.bindItemView(circulatImageList[position])
    }

    class MemberImageViewVH(val memberItemBinding:ChatMemberImageLayoutBinding) : RecyclerView.ViewHolder(memberItemBinding.root) {
        fun bindItemView(imgItem:String){
            memberItemBinding.setVariable(BR.memberItemData, imgItem)
            memberItemBinding.executePendingBindings()
        }
    }

}