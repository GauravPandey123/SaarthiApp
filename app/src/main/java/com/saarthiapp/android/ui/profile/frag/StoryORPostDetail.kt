package com.saarthiapp.android.ui.profile.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentStoryORPostDetailBinding

class StoryORPostDetail : Fragment() {

    private lateinit var fragStoryPostDetailBinding:FragmentStoryORPostDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragStoryPostDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_story_o_r_post_detail, container, false)

        return fragStoryPostDetailBinding.root
    }
}