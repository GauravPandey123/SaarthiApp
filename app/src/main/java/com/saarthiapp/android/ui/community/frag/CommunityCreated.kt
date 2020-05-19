package com.saarthiapp.android.ui.community.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentCommunityCreatedBinding

class CommunityCreated : Fragment(), View.OnClickListener {

    private lateinit var fragCommunityCreatedBinding:FragmentCommunityCreatedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragCommunityCreatedBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_community_created, container, false)

        fragCommunityCreatedBinding.clShareCommunity.setOnClickListener(this)
        fragCommunityCreatedBinding.clJoinCoronaCommunity.setOnClickListener(this)
        return fragCommunityCreatedBinding.root
    }

    override fun onClick(p0: View?) {
        when(p0){

            fragCommunityCreatedBinding.clJoinCoronaCommunity -> {

            }

            fragCommunityCreatedBinding.clShareCommunity -> {

            }
        }
    }

}
