package com.saarthiapp.android.ui.profile

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
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.saarthiapp.android.BR

import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.chat.ChatMemberViewAdapter
import com.saarthiapp.android.adapter.chat.CommunityStoryAdapter
import com.saarthiapp.android.adapter.generic.GenericAdapter
import com.saarthiapp.android.databinding.EventHostedItemLayoutBinding
import com.saarthiapp.android.databinding.FragmentMyProfileBinding
import com.saarthiapp.android.model.event.EventHostData

class MyProfile : Fragment(), View.OnClickListener {

    private lateinit var fragMyProfileBindging:FragmentMyProfileBinding
    private lateinit var navController:NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragMyProfileBindging = DataBindingUtil.inflate(inflater,
            R.layout.fragment_my_profile, container, false)

        setupRecyclerView()
        return fragMyProfileBindging.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragMyProfileBindging.imgEditProfile.setOnClickListener(this)
        fragMyProfileBindging.tvEventHostedText.setOnClickListener(this)
        fragMyProfileBindging.tvCommunityText.setOnClickListener(this)
        fragMyProfileBindging.tvUserStoryText.setOnClickListener(this)
    }

    private fun setupRecyclerView(){
        val imgActorList = ArrayList<String>()
        imgActorList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTu0wHhpMSL7VEw7_uYb4-uJGnm1E0UWvNi2OW79p7U47c1UtU9&usqp=CAU")
        imgActorList.add("https://images.newindianexpress.com/uploads/user/imagelibrary/2017/8/24/w600X300/emraan_haashmi.JPG")
        imgActorList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT1q6-k4l4lQ3ljOnpPA0q9iNOkJMG3ymYfqV85qLJ4e6CmT-Tc&usqp=CAU")
        imgActorList.add("https://lh3.googleusercontent.com/proxy/N_wIJBs7wMEv_gEAi3XH3FQRy0bfh3fC61WE5TlrwWvkL71zgxpZy_N4FXS0kArTX62ssk9FdNM_vLlom3hVLMGDI76-a4Q1kPtofk73CX4-zoEPNjgGOls7TKl2YZpS3LO3rFtBnJwRUQeO")
        imgActorList.add("https://www.globalcosmeticsnews.com/wp-content/uploads/2018/08/ranveer-singh.jpeg")
        imgActorList.add("https://qph.fs.quoracdn.net/main-qimg-f4cb5b141e1f8c49decf37744fad274f")
        imgActorList.add("https://static01.nyt.com/images/2013/05/06/world/asia/06-ranbir-kapoor-IndiaInk/06-ranbir-kapoor-IndiaInk-superJumbo.jpg")
        imgActorList.add("https://i.pinimg.com/originals/f8/77/47/f87747b29fc4d94da8ff2b96cdc805ed.jpg")

        val chatImageAdapter = ChatMemberViewAdapter(requireContext(), imgActorList)

        val suggestedCommunityAdapter = CommunityStoryAdapter(requireContext(), imgActorList)
        fragMyProfileBindging.recViewUserStories.apply {
            adapter = suggestedCommunityAdapter
        }

        val eventHostList = ArrayList<EventHostData>()
        eventHostList.add(EventHostData(1, "https://images.unsplash.com/photo-1590953798185-d009f4a1f127?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80", "Fight Against Corona", "The outbreak was declared a Public Health Emergency of International Concern on 30 January 2020", 18))
        eventHostList.add(EventHostData(1, "https://images.unsplash.com/photo-1523580494863-6f3031224c94?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80", "Fight Against Corona", "The outbreak was declared a Public Health Emergency of International Concern on 30 January 2020", 5))
        fragMyProfileBindging.recViewUserCommunity.adapter = object : GenericAdapter<EventHostData, EventHostedItemLayoutBinding>(requireContext(), eventHostList){
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


        fragMyProfileBindging.recViewUserEventHosts.adapter = object : GenericAdapter<EventHostData, EventHostedItemLayoutBinding>(requireContext(), eventHostList){
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

    override fun onClick(p0: View?) {
        when(p0){

            fragMyProfileBindging.imgEditProfile -> {
                navController.navigate(R.id.action_myProfile_to_editProfileFrag)
            }

            fragMyProfileBindging.tvEventHostedText -> {
                navController.navigate(R.id.action_myProfile_to_eventHostedView)
            }

            fragMyProfileBindging.tvCommunityText -> {
//                navController.navigate(R.id.action_myProfile_to_editProfileFrag)
            }

            fragMyProfileBindging.tvUserStoryText -> {
//                navController.navigate(R.id.action_myProfile_to_editProfileFrag)
            }
        }
    }

}
