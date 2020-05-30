package com.saarthiapp.android.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.chat.ChatImageViewAdapter
import com.saarthiapp.android.databinding.FragmentChatHomeBinding
import com.saarthiapp.android.ui.utils.RecyclerViewItemSpacingDecoration

class Chat : Fragment() {

    private lateinit var fragChatHomeBinding:FragmentChatHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragChatHomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_chat_home, container, false)

staticImageData()
        return fragChatHomeBinding.root
    }

    private fun staticImageData(){
        val imgActorList = ArrayList<String>()
        imgActorList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTu0wHhpMSL7VEw7_uYb4-uJGnm1E0UWvNi2OW79p7U47c1UtU9&usqp=CAU")
        imgActorList.add("https://images.newindianexpress.com/uploads/user/imagelibrary/2017/8/24/w600X300/emraan_haashmi.JPG")
        imgActorList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT1q6-k4l4lQ3ljOnpPA0q9iNOkJMG3ymYfqV85qLJ4e6CmT-Tc&usqp=CAU")
        imgActorList.add("https://lh3.googleusercontent.com/proxy/N_wIJBs7wMEv_gEAi3XH3FQRy0bfh3fC61WE5TlrwWvkL71zgxpZy_N4FXS0kArTX62ssk9FdNM_vLlom3hVLMGDI76-a4Q1kPtofk73CX4-zoEPNjgGOls7TKl2YZpS3LO3rFtBnJwRUQeO")
        imgActorList.add("https://www.globalcosmeticsnews.com/wp-content/uploads/2018/08/ranveer-singh.jpeg")
        imgActorList.add("https://qph.fs.quoracdn.net/main-qimg-f4cb5b141e1f8c49decf37744fad274f")
        imgActorList.add("https://static01.nyt.com/images/2013/05/06/world/asia/06-ranbir-kapoor-IndiaInk/06-ranbir-kapoor-IndiaInk-superJumbo.jpg")
        imgActorList.add("https://i.pinimg.com/originals/f8/77/47/f87747b29fc4d94da8ff2b96cdc805ed.jpg")

        val chatImageAdapter = ChatImageViewAdapter(requireContext(), imgActorList)
        val layoutManagerSosHelp = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        fragChatHomeBinding.recViewSOSChat1.apply {
            layoutManager = layoutManagerSosHelp
            addItemDecoration(RecyclerViewItemSpacingDecoration(0,-55,0, 0))
            hasFixedSize()

            adapter = chatImageAdapter
        }

        val layoutManagerCommunity1 = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        fragChatHomeBinding.recViewCommunity1.apply {
            layoutManager = layoutManagerCommunity1
            addItemDecoration(RecyclerViewItemSpacingDecoration(0,-55,0, 0))
            hasFixedSize()

            adapter = chatImageAdapter
        }

        val layoutManagerCommunity2 = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        fragChatHomeBinding.recViewCommunity2.apply {
            layoutManager = layoutManagerCommunity2
            addItemDecoration(RecyclerViewItemSpacingDecoration(0,-55,0, 0))
            hasFixedSize()

            adapter = chatImageAdapter
        }
    }
}
