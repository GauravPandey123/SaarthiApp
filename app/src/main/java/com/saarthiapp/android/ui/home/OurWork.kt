package com.saarthiapp.android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.ourWork.OurWorkFragmentPagerAdapter
import com.saarthiapp.android.databinding.FragmentOurWorkBinding
import com.saarthiapp.android.ui.ourWorkFrag.CommunityFrag
import com.saarthiapp.android.ui.ourWorkFrag.EventFrag
import com.saarthiapp.android.ui.ourWorkFrag.FeedFrag

class OurWork : Fragment(), View.OnClickListener {

    private lateinit var fragOurWorkBinding:FragmentOurWorkBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragOurWorkBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_our_work, container, false)

        setFragmentStatePagerAdapter()
        return fragOurWorkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        fragOurWorkBinding.clSearchVolunteerLayout.setOnClickListener(this)
    }
    private fun setFragmentStatePagerAdapter(){
        val adapter = OurWorkFragmentPagerAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(FeedFrag(), "Feeds")
        adapter.addFragment(CommunityFrag(), "Community")
        adapter.addFragment(EventFrag(), "Events")
        fragOurWorkBinding.vpOurWork.adapter = adapter
        fragOurWorkBinding.tlOurWork.setupWithViewPager(fragOurWorkBinding.vpOurWork)
    }

    override fun onClick(view: View?) {
        when(view){

            fragOurWorkBinding.clSearchVolunteerLayout -> {
                navController.navigate(R.id.action_ourWork_to_searchVolunteerFrag)
            }
        }
    }

}
