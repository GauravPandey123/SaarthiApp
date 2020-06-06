package com.saarthiapp.android.ui.profile.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.saarthiapp.android.BR
import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.generic.GenericAdapter
import com.saarthiapp.android.databinding.EventHostedItemLayoutBinding
import com.saarthiapp.android.databinding.FragmentEventHostedViewBinding
import com.saarthiapp.android.model.event.EventHostData

class EventHostedView : Fragment() {

    private lateinit var fragEventHostedBinding:FragmentEventHostedViewBinding
    private lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragEventHostedBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_event_hosted_view, container, false)

        return fragEventHostedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val eventHostList = ArrayList<EventHostData>()
        eventHostList.add(EventHostData(1, "https://images.unsplash.com/photo-1590953798185-d009f4a1f127?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80", "Fight Against Corona", "The outbreak was declared a Public Health Emergency of International Concern on 30 January 2020", 18))
        eventHostList.add(EventHostData(1, "https://images.unsplash.com/photo-1523580494863-6f3031224c94?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80", "Fight Against Corona", "The outbreak was declared a Public Health Emergency of International Concern on 30 January 2020", 5))
        fragEventHostedBinding.recViewEventHosted.adapter = object : GenericAdapter<EventHostData, EventHostedItemLayoutBinding>(requireContext(), eventHostList){
            override fun getLayoutResId(): Int {
                return R.layout.event_hosted_item_layout
            }

            override fun onBindData(
                model: EventHostData,
                position: Int,
                dataBinding: EventHostedItemLayoutBinding
            ) {
                dataBinding.setVariable(BR.eventHostModel, model)
                dataBinding.executePendingBindings()
            }

            override fun onItemClick(model: EventHostData, position: Int) {

            }

        }
    }
}