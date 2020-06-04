package com.saarthiapp.android.ui.profile.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentEventHostedAddUpdateBinding

class EventHostedAddUpdate : Fragment() {

    private lateinit var fragEventHostUpdateBinding:FragmentEventHostedAddUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragEventHostUpdateBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_event_hosted_add_update, container, false)

        return fragEventHostUpdateBinding.root
    }
}