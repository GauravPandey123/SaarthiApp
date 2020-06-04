package com.saarthiapp.android.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentEditProfileBinding

class EditProfileFrag : Fragment() {

    private lateinit var fragEditProfileBinding:FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragEditProfileBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_edit_profile, container, false)

        return fragEditProfileBinding.root
    }

}
