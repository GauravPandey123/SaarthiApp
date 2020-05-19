package com.saarthiapp.android.ui.auth.frag

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentSuccessVolunteerJoiningBinding
import com.saarthiapp.android.ui.community.CommunityActivity

class SuccessVolunteerJoining : Fragment() {

    private lateinit var fragSuccessJoinBinding:FragmentSuccessVolunteerJoiningBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragSuccessJoinBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_success_volunteer_joining, container, false)
        return fragSuccessJoinBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        handleScreenForCommunity()
    }

    private fun handleScreenForCommunity(){
        Handler().postDelayed({
            val intentLogin = Intent(requireContext(), CommunityActivity::class.java)
            intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentLogin)
            requireActivity().finishAffinity()
        }, 5000)
    }
}
