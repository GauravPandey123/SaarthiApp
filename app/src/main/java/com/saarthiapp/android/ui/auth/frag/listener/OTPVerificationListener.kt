package com.saarthiapp.android.ui.auth.frag.listener

interface OTPVerificationListener {
    fun otpVerifyData(otpValue:String)
    fun resendOtpCall(resend:Boolean)
}