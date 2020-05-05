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
import com.saarthiapp.android.databinding.FragmentCreatePasswordBinding

class CreatePassword : Fragment(), View.OnClickListener {

    private lateinit var fragCreatePassBinding:FragmentCreatePasswordBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragCreatePassBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_create_password, container, false)
        return fragCreatePassBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragCreatePassBinding.btnPassResetSuccess.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            fragCreatePassBinding.btnPassResetSuccess -> {
                navController.popBackStack(R.id.signInFrag, false)
            }
        }
    }
}
