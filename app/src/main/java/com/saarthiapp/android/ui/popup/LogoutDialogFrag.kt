package com.saarthiapp.android.ui.popup

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.LogoutPopupLayoutBinding

class LogoutDialogFrag : DialogFragment() {

    private lateinit var logoutPopupLayoutBinding:LogoutPopupLayoutBinding
    private lateinit var logoutListener: LogoutDismissListener

    fun setLogoutListener(logoutListener: LogoutDismissListener){
        this.logoutListener = logoutListener
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        logoutPopupLayoutBinding = DataBindingUtil.inflate(inflater,
            R.layout.logout_popup_layout, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        logoutPopupLayoutBinding.tvLogoutNo.setOnClickListener {
            dismiss()
        }

        logoutPopupLayoutBinding.tvLogoutYes.setOnClickListener {
            logoutListener.onLogoutDismiss()
            dismissAllowingStateLoss()
        }
        return logoutPopupLayoutBinding.root
    }

    interface LogoutDismissListener{
        fun onLogoutDismiss()
    }
}