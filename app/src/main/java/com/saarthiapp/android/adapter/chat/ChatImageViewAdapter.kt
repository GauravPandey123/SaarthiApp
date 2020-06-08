package com.saarthiapp.android.adapter.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.saarthiapp.android.BR
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ChatImageCustomTextviewLayoutBinding
import com.saarthiapp.android.databinding.ChatImageOverlapLayoutBinding

class ChatImageViewAdapter(val mCtx:Context, val circulatImageList:List<String>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_IMAGE = 0
    private val TYPE_TEXT_COUNT = 1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        when(viewType){
            TYPE_TEXT_COUNT -> {
                val imgCountItemBinding:ChatImageCustomTextviewLayoutBinding
                        = DataBindingUtil.inflate(LayoutInflater.from(mCtx),
                    R.layout.chat_image_custom_textview_layout, parent, false)
                return CircualrImageCountVH(imgCountItemBinding)
            }

            else -> {
                val imgItemBinding:ChatImageOverlapLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mCtx),
                    R.layout.chat_image_overlap_layout, parent, false)
                return CircularImageViewVH(imgItemBinding)
            }
        }
    }

    override fun getItemCount(): Int {
       return circulatImageList.size
    }

    override fun getItemViewType(position: Int): Int {
        if((itemCount-1) == position){
            return TYPE_TEXT_COUNT
        }else{
            return TYPE_IMAGE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == TYPE_TEXT_COUNT){
            (holder as CircualrImageCountVH).bindItemView("+131")
        }else{
            (holder as CircularImageViewVH).bindItemView(circulatImageList[position])
        }
    }

    class CircularImageViewVH(val imgItemBinding:ChatImageOverlapLayoutBinding) : RecyclerView.ViewHolder(imgItemBinding.root) {
        fun bindItemView(imgItem:String){
            imgItemBinding.setVariable(BR.imgItemData, imgItem)
            imgItemBinding.executePendingBindings()
        }
    }

    class CircualrImageCountVH(val imgCountItemBinding:ChatImageCustomTextviewLayoutBinding)
        : RecyclerView.ViewHolder(imgCountItemBinding.root) {

        fun bindItemView(imgItem:String){
            imgCountItemBinding.setVariable(BR.chatMemberTotalCount, imgItem)
            imgCountItemBinding.executePendingBindings()
        }
    }
}