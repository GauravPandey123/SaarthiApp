package com.saarthiapp.android.ui.home.drawerFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentRateOurAppBinding


class RateOurApp : Fragment() {

    private lateinit var fragRateAppBinding:FragmentRateOurAppBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragRateAppBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_rate_our_app, container, false)
        return fragRateAppBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
