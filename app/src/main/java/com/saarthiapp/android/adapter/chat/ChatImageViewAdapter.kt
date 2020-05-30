package com.saarthiapp.android.adapter.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.saarthiapp.android.BR
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ChatImageOverlapLayoutBinding

class ChatImageViewAdapter(val mCtx:Context, val circulatImageList:List<String>)
    : RecyclerView.Adapter<ChatImageViewAdapter.CircularImageViewVH>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CircularImageViewVH {
        val imgItemBinding:ChatImageOverlapLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mCtx),
        R.layout.chat_image_overlap_layout, parent, false)
        return CircularImageViewVH(imgItemBinding)
    }

    override fun getItemCount(): Int {
       return circulatImageList.size
    }

    override fun onBindViewHolder(holder: CircularImageViewVH, position: Int) {
        holder.bindItemView(circulatImageList[position])
    }

    class CircularImageViewVH(val imgItemBinding:ChatImageOverlapLayoutBinding) : RecyclerView.ViewHolder(imgItemBinding.root) {
        fun bindItemView(imgItem:String){
            imgItemBinding.setVariable(BR.imgItemData, imgItem)
            imgItemBinding.executePendingBindings()
        }
    }

}