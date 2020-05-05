package com.saarthiapp.android.ui.auth.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentFingerRecognitionBinding

class FingerRecognition : Fragment(), View.OnClickListener {

    private lateinit var fragFingerVerifyBinding:FragmentFingerRecognitionBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragFingerVerifyBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_finger_recognition, container, false)
        return fragFingerVerifyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragFingerVerifyBinding.btnFingerVerifyFinish.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            fragFingerVerifyBinding.btnFingerVerifyFinish -> {
                navController.navigate(R.id.action_fingerRecognition_to_successVolunteerJoining)
            }
        }
    }
}
