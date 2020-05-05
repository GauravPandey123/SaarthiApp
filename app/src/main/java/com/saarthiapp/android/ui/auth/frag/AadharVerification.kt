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
import com.saarthiapp.android.databinding.FragmentAadharVerificationBinding

class AadharVerification : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var fragAadharVerifyBinding:FragmentAadharVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragAadharVerifyBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_aadhar_verification, container, false)
        return fragAadharVerifyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragAadharVerifyBinding.btnAadharNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            fragAadharVerifyBinding.btnAadharNext -> {
                navController.navigate(R.id.action_aadharVerification_to_faceVerification)
            }
        }
    }
}
