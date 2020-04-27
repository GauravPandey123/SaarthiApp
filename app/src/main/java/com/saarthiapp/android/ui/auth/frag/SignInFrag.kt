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
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.FragmentSignInBinding

class SignInFrag : Fragment() {

    private lateinit var fragmentSignInBinding: FragmentSignInBinding
    private val startSpanText = 23
    private val startTermsText = 36

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentSignInBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in, container, false)
        setLoginTextClickable()
        return fragmentSignInBinding.root
    }

    private fun setLoginTextClickable(){
        val ssLoginText = SpannableString(resources.getString(R.string.strDontSignInText))
        ssLoginText.setSpan(
            ForegroundColorSpan(Color.parseColor("#ffffff")),
            startSpanText, ssLoginText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        ssLoginText.setSpan(StyleSpan(Typeface.BOLD), startSpanText, ssLoginText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val spanRegNow =  object : ClickableSpan() {
            override fun onClick(widget: View) {
                val navController = Navigation.findNavController(widget)
                navController.navigate(R.id.action_signInFrag_to_signUpFrag)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        ssLoginText.setSpan(spanRegNow, startSpanText, ssLoginText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        fragmentSignInBinding.tvdontAccountSignUp.movementMethod = LinkMovementMethod.getInstance()
        fragmentSignInBinding.tvdontAccountSignUp.text = ssLoginText


        val ssTermsText = SpannableString(resources.getString(R.string.strAcceptingTermServices))
        ssTermsText.setSpan(ForegroundColorSpan(Color.parseColor("#ffffff")),
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
        fragmentSignInBinding.tvBySigningTerms.movementMethod = LinkMovementMethod.getInstance()
        fragmentSignInBinding.tvBySigningTerms.text = ssTermsText
    }

}
