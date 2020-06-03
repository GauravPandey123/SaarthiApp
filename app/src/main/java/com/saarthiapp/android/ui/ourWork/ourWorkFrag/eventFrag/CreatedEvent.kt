package com.saarthiapp.android.ui.ourWork.ourWorkFrag.eventFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.saarthiapp.android.R

class CreatedEvent : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_created_event, container, false)
    }

}
