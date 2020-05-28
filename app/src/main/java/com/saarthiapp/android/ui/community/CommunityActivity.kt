package com.saarthiapp.android.ui.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ActivityCommunityBinding
import com.saarthiapp.android.ui.activity.HomeActivity

class CommunityActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var actCommunityBinding:ActivityCommunityBinding
    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.communityNavHostFragmentContainer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actCommunityBinding = DataBindingUtil.setContentView(this, R.layout.activity_community)

        navController.addOnDestinationChangedListener{controller, destination, arguments ->
            val titleValue =  when(destination.id){
                R.id.howITWorks -> destination.label
                R.id.communities -> destination.label
                R.id.communityCreated -> destination.label
                R.id.createNewCommunity -> destination.label

                else -> "Login"
            }
            Log.e("Title Of Fragment", " :: $titleValue")
            setupToolbarTitle(titleValue.toString())
        }

        actCommunityBinding.imgBackArrow.setOnClickListener(this)
        actCommunityBinding.imgBackArrow2.setOnClickListener(this)
        actCommunityBinding.tvSkipCommunity.setOnClickListener(this)
    }

    private fun setupToolbarTitle(title:String){
        if(title.equals("HowITWorks", true)){
            actCommunityBinding.clCustomToolbarComm1.visibility = View.GONE
            actCommunityBinding.clCustomToolbarComm2.visibility = View.GONE
        }else if(title.equals("Communities", true)){
            actCommunityBinding.clCustomToolbarComm1.visibility = View.VISIBLE
            actCommunityBinding.clCustomToolbarComm2.visibility = View.GONE
        }else if(title.equals("Community Created", true)){
            actCommunityBinding.clCustomToolbarComm1.visibility = View.GONE
            actCommunityBinding.clCustomToolbarComm2.visibility = View.VISIBLE
            actCommunityBinding.tvToolbarCommunityTitle.text = title
        }else if(title.equals("Create New Community", true)){
            actCommunityBinding.clCustomToolbarComm1.visibility = View.GONE
            actCommunityBinding.clCustomToolbarComm2.visibility = View.VISIBLE
            actCommunityBinding.tvToolbarCommunityTitle.text = title
        }
    }

    override fun onClick(p0: View?) {
        when(p0){

            actCommunityBinding.imgBackArrow -> {
                navController.navigateUp()
            }

            actCommunityBinding.imgBackArrow2 -> {
                navController.navigateUp()
            }

            actCommunityBinding.tvSkipCommunity -> {
                val intentLogin = Intent(this@CommunityActivity, HomeActivity::class.java)
//                intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intentLogin)
//                finishAffinity()
            }
        }
    }
}