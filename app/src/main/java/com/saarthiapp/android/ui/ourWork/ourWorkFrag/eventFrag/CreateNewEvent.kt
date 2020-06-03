package com.saarthiapp.android.ui.ourWork.ourWorkFrag.eventFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentCreateNewEventBinding

class CreateNewEvent : Fragment() {

    private lateinit var fragCreateNewEventBinding:FragmentCreateNewEventBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragCreateNewEventBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_create_new_event, container, false)

        return fragCreateNewEventBinding.root
    }

}
