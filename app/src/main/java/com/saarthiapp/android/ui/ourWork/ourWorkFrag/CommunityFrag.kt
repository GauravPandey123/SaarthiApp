package com.saarthiapp.android.ui.ourWork.ourWorkFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentCommunityBinding

class CommunityFrag : Fragment() {

    private lateinit var fragCommunityWorkBinding:FragmentCommunityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragCommunityWorkBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_community, container, false)

        return fragCommunityWorkBinding.root
    }

}
