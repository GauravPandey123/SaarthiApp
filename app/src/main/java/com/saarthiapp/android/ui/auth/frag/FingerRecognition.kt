package com.saarthiapp.android.ui.auth.frag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.biometric.BiometricPrompt
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentFingerRecognitionBinding
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class FingerRecognition : Fragment(), View.OnClickListener {

    private lateinit var fragFingerVerifyBinding:FragmentFingerRecognitionBinding
    private lateinit var navController: NavController
    private lateinit var mBiometricPromptInfo:BiometricPrompt.PromptInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragFingerVerifyBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_finger_recognition, container, false)

       mBiometricPromptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Title text goes here")
            .setSubtitle("Subtitle goes here")
            .setDescription("This is the description")
            .setNegativeButtonText("Cancel")
            .build()
        return fragFingerVerifyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newExecutor = Executors.newSingleThreadExecutor()
        val biometricPrompt = BiometricPrompt(requireActivity(), newExecutor, object : BiometricPrompt.AuthenticationCallback(){

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Log.e("onSucceeded", " :: Biometric Success :: ${result.cryptoObject}")
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)

                Log.e("onAuthError", " :: Biometric Success :: $errorCode :: $errString")
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()

                Log.e("onFailed", " :: Biometric Success")
            }
        })
        biometricPrompt.authenticate(mBiometricPromptInfo)

        navController = Navigation.findNavController(view)
        fragFingerVerifyBinding.btnFingerVerifyFinish.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            fragFingerVerifyBinding.btnFingerVerifyFinish -> {
                navController.navigate(R.id.action_fingerRecognition_to_successVolunteerJoining)
            }
        }
    }
}
