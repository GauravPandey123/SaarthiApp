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
import com.saarthiapp.android.databinding.FragmentMyProfileBinding

class MyProfile : Fragment(), View.OnClickListener {

    private lateinit var fragMyProfileBindging:FragmentMyProfileBinding
    private lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragMyProfileBindging = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false)
        return fragMyProfileBindging.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragMyProfileBindging.imgEditProfile.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            fragMyProfileBindging.imgEditProfile -> {
                navController.navigate(R.id.action_myProfile_to_editProfileFrag)
            }
        }
    }

}
