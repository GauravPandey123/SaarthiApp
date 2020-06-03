package com.saarthiapp.android.ui.ourWork.ourWorkFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentEventBinding

class EventFrag : Fragment() {

    private lateinit var fragEventBinding:FragmentEventBinding
    private lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragEventBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_event, container, false)

        return fragEventBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        fragEventBinding.clCreateNewEvent.setOnClickListener{
            navController.navigate(R.id.action_eventFrag_to_createNewEvent)
        }
    }
}
