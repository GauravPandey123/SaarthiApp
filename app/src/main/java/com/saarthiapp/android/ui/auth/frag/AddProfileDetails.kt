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
import com.saarthiapp.android.databinding.FragmentAddProfileDetailsBinding

class AddProfileDetails : Fragment(), View.OnClickListener {

    private lateinit var fragAddProfileDetailBinding:FragmentAddProfileDetailsBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragAddProfileDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add_profile_details, container, false)

        return fragAddProfileDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragAddProfileDetailBinding.btnProfileNext.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){

            fragAddProfileDetailBinding.btnProfileNext -> {
                navController.navigate(R.id.action_addProfileDetails_to_aadharVerification)
            }
        }
    }
}
