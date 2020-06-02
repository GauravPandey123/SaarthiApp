package com.saarthiapp.android.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentCommunityChatBinding

class CommunityChat : Fragment(), View.OnClickListener {

    private lateinit var fragCommunityChat:FragmentCommunityChatBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragCommunityChat = DataBindingUtil.inflate(inflater,
            R.layout.fragment_community_chat, container, false)
        return fragCommunityChat.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        fragCommunityChat.clUpcomingEventLayout.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            fragCommunityChat.clUpcomingEventLayout -> {
                navController.navigate(R.id.action_communityChat_to_upcomingEvent)
            }
        }
    }
}
