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
import com.saarthiapp.android.databinding.FragmentPrivacyPolicyBinding

class PrivacyPolicy : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private lateinit var fragPrivacyPolicyBinding:FragmentPrivacyPolicyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragPrivacyPolicyBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_privacy_policy, container, false)
        return fragPrivacyPolicyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragPrivacyPolicyBinding.btnAgreePolicy.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            fragPrivacyPolicyBinding.btnAgreePolicy -> {
                navController.navigate(R.id.action_privacyPolicy_to_addProfileDetails)
            }
        }
    }


}
