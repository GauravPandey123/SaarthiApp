package com.saarthiapp.android.ui.popup

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.OtpVerifyDialogLayoutBinding
import com.saarthiapp.android.ui.auth.frag.listener.OTPVerificationListener
import java.util.*

class OtpVerificaitonDialog : DialogFragment(), View.OnClickListener {

    private lateinit var otpVerifyDialogLayoutBinding: OtpVerifyDialogLayoutBinding
    private var otpVerifyListener:OTPVerificationListener ?= null

    private var  mActivity: Activity?= null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity
    }

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
        setTimer()

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

    private fun setTimer(){

        var seconds = 60
        val timerOtp = Timer()
        timerOtp.scheduleAtFixedRate(object : TimerTask() {

            override fun run() {
                mActivity!!.runOnUiThread {
                    otpVerifyDialogLayoutBinding.tvOTPTimer.text = "$seconds Sec"
                    seconds -= 1

                    if(seconds == 0) {
                        otpVerifyDialogLayoutBinding.clOTPTimer.visibility = View.GONE
                        otpVerifyDialogLayoutBinding.tvResentOtp.visibility = View.VISIBLE
                        timerOtp.purge()
                    }
                }
            }
        }, 0, 1000)
    }
}