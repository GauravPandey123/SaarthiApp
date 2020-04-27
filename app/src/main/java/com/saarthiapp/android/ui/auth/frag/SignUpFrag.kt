package com.saarthiapp.android.ui.auth.frag

import android.content.Intent
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
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentSignUpBinding
import com.saarthiapp.android.ui.activity.HomeActivity

class SignUpFrag : Fragment(), View.OnClickListener {

    private lateinit var fragmentSignUpBinding: FragmentSignUpBinding
    private val startSpanText = 25
    private val startTermsText = 36

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentSignUpBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        setSignupTextClickable()
        return fragmentSignUpBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSignUpBinding.btnSignUp.setOnClickListener(this)
    }

    private fun setSignupTextClickable(){
        val ssSignUpText = SpannableString(resources.getString(R.string.strAlreadyAccountSignIn))
        ssSignUpText.setSpan(
            ForegroundColorSpan(Color.parseColor("#ffffff")),
            startSpanText, ssSignUpText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        ssSignUpText.setSpan(StyleSpan(Typeface.BOLD), startSpanText, ssSignUpText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val spanRegNow =  object : ClickableSpan() {
            override fun onClick(widget: View) {
                val navController = Navigation.findNavController(widget)
                navController.popBackStack()
//                Toast.makeText(requireContext(), "Task is Pending", Toast.LENGTH_SHORT).show()
//                navController.navigate(R.id.action_signInFrag_to_signUpFrag)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        ssSignUpText.setSpan(spanRegNow, startSpanText, ssSignUpText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        fragmentSignUpBinding.tvdontAccountSignUp.movementMethod = LinkMovementMethod.getInstance()
        fragmentSignUpBinding.tvdontAccountSignUp.text = ssSignUpText


        val ssTermsText = SpannableString(resources.getString(R.string.strSignUpTermsText))
        ssTermsText.setSpan(
            ForegroundColorSpan(Color.parseColor("#ffffff")),
            startTermsText, ssTermsText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        ssTermsText.setSpan(StyleSpan(Typeface.BOLD), startTermsText, ssTermsText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val spanTermsCondition =  object : ClickableSpan() {
            override fun onClick(widget: View) {
                val navController = Navigation.findNavController(widget)
                Toast.makeText(requireContext(), "Task is Pending", Toast.LENGTH_SHORT).show()
//                navController.navigate(R.id.action_signInFrag_to_signUpFrag)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        ssTermsText.setSpan(spanTermsCondition, startTermsText, ssTermsText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        fragmentSignUpBinding.tvBySigningTerms.movementMethod = LinkMovementMethod.getInstance()
        fragmentSignUpBinding.tvBySigningTerms.text = ssTermsText
    }

    override fun onClick(view: View?) {
        when(view) {

            fragmentSignUpBinding.btnSignUp -> {
                val intentHome = Intent(requireActivity(), HomeActivity::class.java)
                intentHome.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                requireActivity().startActivity(intentHome)
                requireActivity().finishAffinity()
            }
        }
    }

}
