package com.saarthiapp.android.ui.popup

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.PostYourStoryPopupLayoutBinding

class PostStoryDialog : DialogFragment(), View.OnClickListener {

    private lateinit var postStoryLayoutBinding: PostYourStoryPopupLayoutBinding
//    private var donationDismissListener:DonateDismissListener ?= null

    private var  mActivity: Activity?= null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = activity
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    /*fun setDonateDismissListener(donationDismissListener:DonateDismissListener){
        this.donationDismissListener = donationDismissListener
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
        postStoryLayoutBinding = DataBindingUtil.inflate(inflater,
            R.layout.post_your_story_popup_layout, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        postStoryLayoutBinding.btnPostYourStory.setOnClickListener(this)
        postStoryLayoutBinding.imgClosePopup.setOnClickListener(this)
        return postStoryLayoutBinding.root
    }

    override fun onClick(p0: View?) {
        when(p0){
            postStoryLayoutBinding.btnPostYourStory -> {
//                donationDismissListener?.onDismissDonation()
                dismissAllowingStateLoss()
            }

            postStoryLayoutBinding.imgClosePopup -> {
                dismissAllowingStateLoss()
            }
        }
    }

    interface PostStoryDialogListener{
//        fun onDismissDonation()
    }
}