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
import com.saarthiapp.android.databinding.FragmentCreateNewCommunityBinding

class CreateNewCommunity : Fragment(), View.OnClickListener {

    private lateinit var fragmentCreateNewCommunityBinding: FragmentCreateNewCommunityBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentCreateNewCommunityBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_create_new_community, container, false)

        fragmentCreateNewCommunityBinding.clCreateCommunity.setOnClickListener(this)
        return fragmentCreateNewCommunityBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }
    override fun onClick(p0: View?) {
        when(p0){

            fragmentCreateNewCommunityBinding.clCreateCommunity -> {
                navController.navigate(R.id.action_createNewCommunity_to_communityCreated)
            }
        }
    }

}
