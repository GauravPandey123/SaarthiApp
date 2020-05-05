package com.saarthiapp.android.ui.auth.frag

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentForgotPasswordBinding
import com.saarthiapp.android.ui.auth.frag.listener.OTPVerificationListener
import com.saarthiapp.android.ui.popup.OtpVerificaitonDialog

class ForgotPassword : Fragment(), View.OnClickListener, OTPVerificationListener {

    private lateinit var navController: NavController
    private lateinit var fragForgotPassBinding:FragmentForgotPasswordBinding
    private val startSpanText = 0
    private val endSpanText = 7

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragForgotPassBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_forgot_password, container, false)
        setupSignInInsteadClickable()
        return fragForgotPassBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragForgotPassBinding.btnForgotPassNext.setOnClickListener(this)
    }

    private fun setupSignInInsteadClickable(){
        val ssSignInInstead = SpannableString(resources.getString(R.string.strSignInInstead))
        ssSignInInstead.setSpan(
            ForegroundColorSpan(Color.parseColor("#ffffff")),
            startSpanText, endSpanText, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        ssSignInInstead.setSpan(StyleSpan(Typeface.BOLD), startSpanText, endSpanText, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val spanRegNow =  object : ClickableSpan() {
            override fun onClick(widget: View) {
                val navController = Navigation.findNavController(widget)
                navController.popBackStack(R.id.signInFrag, false)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        ssSignInInstead.setSpan(spanRegNow, startSpanText, endSpanText, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        fragForgotPassBinding.tvSignInstead.movementMethod = LinkMovementMethod.getInstance()
        fragForgotPassBinding.tvSignInstead.text = ssSignInInstead
    }

    override fun onClick(view: View?) {
        when(view){
            fragForgotPassBinding.btnForgotPassNext -> {
                val verifyOTPPopup = OtpVerificaitonDialog()
                verifyOTPPopup.isCancelable = true
                verifyOTPPopup.setOTPVerificationListener(this)
                verifyOTPPopup.show(requireActivity().supportFragmentManager,
                    "Verify OTP From Forgot Password Side...")
            }
        }
    }

    override fun otpVerifyData(otpValue: String) {
        navController.navigate(R.id.action_forgotPassword_to_createPassword)
    }

    override fun resendOtpCall(resend: Boolean) {

    }
}
