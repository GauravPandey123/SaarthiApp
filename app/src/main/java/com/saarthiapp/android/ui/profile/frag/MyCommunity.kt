package com.saarthiapp.android.ui.profile.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentMyCommunityBinding

class MyCommunity : Fragment() {

    private lateinit var fragMyCommunityBinding:FragmentMyCommunityBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragMyCommunityBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_my_community, container, false)

        return fragMyCommunityBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }
}