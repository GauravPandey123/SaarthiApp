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
import com.saarthiapp.android.databinding.FragmentFaceVerificationBinding

class FaceVerification : Fragment(), View.OnClickListener {

    private lateinit var fragFaceVerifyBinding:FragmentFaceVerificationBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragFaceVerifyBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_face_verification, container, false)
        return fragFaceVerifyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragFaceVerifyBinding.btnFaceVerifyNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            fragFaceVerifyBinding.btnFaceVerifyNext -> {
                navController.navigate(R.id.action_faceVerification_to_fingerRecognition)
            }
        }
    }

}
