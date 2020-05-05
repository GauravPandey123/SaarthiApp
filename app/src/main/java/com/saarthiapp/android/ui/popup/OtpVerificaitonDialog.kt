package com.saarthiapp.android.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.OtpVerifyDialogLayoutBinding
import com.saarthiapp.android.ui.auth.frag.listener.OTPVerificationListener

class OtpVerificaitonDialog : DialogFragment(), View.OnClickListener {

    private lateinit var otpVerifyDialogLayoutBinding: OtpVerifyDialogLayoutBinding
    private var otpVerifyListener:OTPVerificationListener ?= null

    fun setOTPVerificationListener(otpVerifyListener:OTPVerificationListener){
        this.otpVerifyListener = otpVerifyListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        otpVerifyDialogLayoutBinding = DataBindingUtil.inflate(inflater,
            R.layout.otp_verify_dialog_layout, container, false)

        otpVerifyDialogLayoutBinding.btnVerifyMobileOTP.setOnClickListener(this)
        return otpVerifyDialogLayoutBinding.root
    }

    override fun onClick(p0: View?) {
        when(p0){

            otpVerifyDialogLayoutBinding.btnVerifyMobileOTP -> {
                otpVerifyListener?.otpVerifyData("")
                dismissAllowingStateLoss()
            }


        }
    }
}