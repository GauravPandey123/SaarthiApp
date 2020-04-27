package com.saarthiapp.android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentSearchVolunteerBinding

class SearchVolunteerFrag : Fragment(), View.OnClickListener {

    private lateinit var fragSearchVolunteerBinding:FragmentSearchVolunteerBinding
    private lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragSearchVolunteerBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_search_volunteer, container, false)
        setUpSearchRecyclerView()
        return fragSearchVolunteerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        fragSearchVolunteerBinding.imgSearchBack.setOnClickListener(this)

    }

    private fun setUpSearchRecyclerView(){
        val layoutManagerSearch = LinearLayoutManager(requireContext())
        fragSearchVolunteerBinding.recViewSearchHint.apply {
            layoutManager = layoutManagerSearch
            itemAnimator = DefaultItemAnimator()
            hasFixedSize()
        }
    }

    override fun onClick(view: View?) {
        when(view) {
            fragSearchVolunteerBinding.imgSearchBack -> {
                navController.popBackStack()
            }
        }
    }

}
