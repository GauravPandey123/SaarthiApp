package com.saarthiapp.android.ui.community.frag

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentHowITWorksBinding
import com.saarthiapp.android.ui.activity.HomeActivity

class HowITWorks : Fragment(), View.OnClickListener {

    private lateinit var fragHowItWorkBinding:FragmentHowITWorksBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        fragHowItWorkBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_how_i_t_works, container, false)
        return fragHowItWorkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragHowItWorkBinding.btnGetStarted.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            fragHowItWorkBinding.btnGetStarted -> {
                navController.navigate(R.id.action_howITWorks_to_communities)
            }
        }
    }

}