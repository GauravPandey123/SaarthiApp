package com.saarthiapp.android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.ourWork.OurWorkFragmentPagerAdapter
import com.saarthiapp.android.databinding.FragmentOurWorkBinding
import com.saarthiapp.android.ui.ourWorkFrag.CommunityFrag
import com.saarthiapp.android.ui.ourWorkFrag.EventFrag
import com.saarthiapp.android.ui.ourWorkFrag.FeedFrag

class OurWork : Fragment() {

    private lateinit var fragOurWorkBinding:FragmentOurWorkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragOurWorkBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_our_work, container, false)

        setFragmentStatePagerAdapter()
        return fragOurWorkBinding.root
    }

    private fun setFragmentStatePagerAdapter(){
        val adapter = OurWorkFragmentPagerAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(FeedFrag(), "Feeds")
        adapter.addFragment(CommunityFrag(), "Community")
        adapter.addFragment(EventFrag(), "Events")
        fragOurWorkBinding.vpOurWork.adapter = adapter
        fragOurWorkBinding.tlOurWork.setupWithViewPager(fragOurWorkBinding.vpOurWork)
    }

}
