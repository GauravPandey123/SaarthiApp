package com.saarthiapp.android.adapter.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ChatSendTopMsgLayoutBinding

class ChatMessageAdapter(val mCtx: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val senderItemBinding:ChatSendTopMsgLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(mCtx),
        R.layout.chat_send_top_msg_layout, parent, false)
        return SenderMsgUser(senderItemBinding)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class SenderMsgUser(val senderItemBinding:ChatSendTopMsgLayoutBinding): RecyclerView.ViewHolder(senderItemBinding.root){

    }


}