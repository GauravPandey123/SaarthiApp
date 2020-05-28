package com.saarthiapp.android.ui.home.drawerFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.donate.CustomSpinnerAdapter
import com.saarthiapp.android.databinding.FragmentDonateBinding
import com.saarthiapp.android.ui.popup.DonateSubmitionDialog
import com.saarthiapp.android.ui.utils.setRobotoFontType

class Donate : Fragment(), DonateSubmitionDialog.DonateDismissListener {

    private lateinit var fragDonateBinding:FragmentDonateBinding
    private lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragDonateBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_donate, container, false)


        return fragDonateBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        fragDonateBinding.tvDonateToCare.setRobotoFontType(requireContext())
        fragDonateBinding.tvWhatDonateText.setRobotoFontType(requireContext())
        fragDonateBinding.tvDonateToCareDesc.setRobotoFontType(requireContext())
        val categoryList = ArrayList<String>()
        categoryList.add("Select Category")
        categoryList.add("Business")
        categoryList.add("Health")
        categoryList.add("Sports")
        categoryList.add("General")

        val qtyAdapter = CustomSpinnerAdapter(requireContext(), categoryList)
        fragDonateBinding.acsSelectCategory.adapter = qtyAdapter
        fragDonateBinding.acsSelectCategory.setSelection(0, false)

        fragDonateBinding.btnDonateSubmit.setOnClickListener {
//            navController.navigate(R.id.action_donateSaarthi_to_donateSubmitionDialog)
            val donationPopup = DonateSubmitionDialog()
            donationPopup.setDonateDismissListener(this)
            donationPopup.isCancelable = true
            donationPopup.show(requireActivity().supportFragmentManager, "Donate Submit Successfully !!")
        }
    }

    override fun onDismissDonation() {
//        navController.popBackStack(R.id.saarthiHome, true)
    }
}
