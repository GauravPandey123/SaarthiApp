package com.saarthiapp.android.ui.community.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentCommunitiesBinding

class Communities : Fragment(), View.OnClickListener {

    private lateinit var fragCommunityBinding:FragmentCommunitiesBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragCommunityBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_communities, container, false)
        return fragCommunityBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragCommunityBinding.clCreateNewCommunity.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            fragCommunityBinding.clCreateNewCommunity -> {
                navController.navigate(R.id.action_communities_to_createNewCommunity)
            }
        }
    }

}
