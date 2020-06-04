package com.saarthiapp.android.ui.popup

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Constraints
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.DonationPopupLayoutBinding
import com.saarthiapp.android.databinding.LeaveCommunityDialogLayoutBinding
import com.saarthiapp.android.databinding.OtpVerifyDialogLayoutBinding
import com.saarthiapp.android.ui.auth.frag.listener.OTPVerificationListener
import java.util.*

class LeaveCommunityDialog : DialogFragment(), View.OnClickListener {

    private lateinit var leaveCommunityBinding: LeaveCommunityDialogLayoutBinding
    private var leaveCommunityListener:LeaveCommunityDialogListener ?= null

    private var  mActivity: Activity?= null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    fun setDonateDismissListener(leaveCommunityListener:LeaveCommunityDialogListener){
        this.leaveCommunityListener = leaveCommunityListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
        leaveCommunityBinding = DataBindingUtil.inflate(inflater,
            R.layout.leave_community_dialog_layout, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        leaveCommunityBinding.tvLogoutYes.setOnClickListener(this)
        leaveCommunityBinding.tvLogoutNo.setOnClickListener(this)
        return leaveCommunityBinding.root
    }

    override fun onClick(p0: View?) {
        when(p0){
            leaveCommunityBinding.tvLogoutYes -> {
                leaveCommunityListener?.onLeaveCommunity(true)
                dismissAllowingStateLoss()
            }

            leaveCommunityBinding.tvLogoutNo -> {
                dismissAllowingStateLoss()
            }
        }
    }

    interface LeaveCommunityDialogListener{
        fun onLeaveCommunity(isLeaved:Boolean)
    }
}