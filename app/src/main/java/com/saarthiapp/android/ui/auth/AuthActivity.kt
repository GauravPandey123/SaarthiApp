package com.saarthiapp.android.ui.auth

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var actAuthBinding:ActivityAuthBinding
    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.authNavHostFragmentContainer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actAuthBinding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        navController.addOnDestinationChangedListener{controller, destination, arguments ->
            val titleValue =  when(destination.id){
                R.id.signInFrag -> destination.label
                R.id.signUpFrag -> destination.label
                R.id.forgotPassword -> destination.label
                R.id.createPassword -> destination.label

                R.id.privacyPolicy -> destination.label
                R.id.addProfileDetails -> destination.label
                R.id.aadharVerification -> destination.label
                R.id.faceVerification -> destination.label
                R.id.fingerRecognition -> destination.label
                R.id.successVolunteerJoining -> destination.label

                else -> "Login"
            }
            Log.e("Title Of Fragment", " :: $titleValue")
            setupToolbarTitle(titleValue.toString())
        }

        actAuthBinding.imgBackArrow.setOnClickListener(this)
    }

    private fun setupToolbarTitle(title:String){
        if(title.equals("sign in", true)){
            actAuthBinding.clCustomToolbar.visibility = View.GONE
        }else if(title.equals("sign up", true)){
            actAuthBinding.clCustomToolbar.visibility = View.GONE
        }else if(title.equals("Forgot Password", true)){
            actAuthBinding.clCustomToolbar.visibility = View.GONE
        }else if(title.equals("Create Password", true)){
            actAuthBinding.clCustomToolbar.visibility = View.GONE
        }else if(title.equals("Privacy Policy", true)){
            actAuthBinding.clCustomToolbar.visibility = View.VISIBLE
            actAuthBinding.tvToolbarTitle.text = title
        }else if(title.equals("Fingerprint Recognition", true)){
            actAuthBinding.clCustomToolbar.visibility = View.VISIBLE
            actAuthBinding.tvToolbarTitle.text = title
        }else if(title.equals("Face Verification", true)){
            actAuthBinding.clCustomToolbar.visibility = View.VISIBLE
            actAuthBinding.tvToolbarTitle.text = title
        }else if(title.equals("Aadhar Verification", true)){
            actAuthBinding.clCustomToolbar.visibility = View.VISIBLE
            actAuthBinding.tvToolbarTitle.text = title
        }else if(title.equals("Add Profile Details", true)){
            actAuthBinding.clCustomToolbar.visibility = View.VISIBLE
            actAuthBinding.tvToolbarTitle.text = title
        }else if(title.equals("Success Volunteer Joining", true)){
            actAuthBinding.clCustomToolbar.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("nav", " :: ${navController.currentDestination?.label}")
    }

    override fun onClick(v: View?) {
        when(v){
            actAuthBinding.imgBackArrow -> {
                navController.navigateUp()
            }
        }
    }
}
