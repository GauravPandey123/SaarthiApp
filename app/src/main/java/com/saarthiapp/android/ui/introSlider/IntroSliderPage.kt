package com.saarthiapp.android.ui.introSlider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.introSlider.IntroSliderVPAdapter
import com.saarthiapp.android.databinding.ActivityIntroSliderPageBinding
import com.saarthiapp.android.model.introSlider.IntroSliderData
import com.saarthiapp.android.ui.auth.AuthActivity
import java.util.*
import kotlin.collections.ArrayList

class IntroSliderPage : AppCompatActivity(), ViewPager.OnPageChangeListener, View.OnClickListener {

    private lateinit var actIntroSliderBinding:ActivityIntroSliderPageBinding
    private val DELAY_MS: Long = 4000 //delay in milliseconds before task is to be executed
    private val PERIOD_MS: Long = 6000 // time in milliseconds between successive task executions.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actIntroSliderBinding = DataBindingUtil.setContentView(this, R.layout.activity_intro_slider_page)
        setupIntroSlider()

        actIntroSliderBinding.clNextIntroSlider.setOnClickListener(this)
        actIntroSliderBinding.tvSkipIntroSlider.setOnClickListener(this)
    }

    private fun setupIntroSlider(){
        val sliderDataList = ArrayList<IntroSliderData>()
        sliderDataList.add(IntroSliderData(resources.getString(R.string.strHelpTogether), R.drawable.help_together, resources.getString(R.string.strHelpTogetherDesc)))
        sliderDataList.add(IntroSliderData(resources.getString(R.string.strEasyToHelp), R.drawable.easy_to_help, resources.getString(R.string.strEasyToHelpDesc)))
        sliderDataList.add(IntroSliderData(resources.getString(R.string.strBeSaarthi), R.drawable.be_a_saarthi, resources.getString(R.string.strBeSaarthiDesc)))
        sliderDataList.add(IntroSliderData(resources.getString(R.string.strBeChangemaker), R.drawable.be_a_changemaker, resources.getString(R.string.strBeChangemakerDesc)))

        val introAdapter = IntroSliderVPAdapter(this, sliderDataList)
        actIntroSliderBinding.vpIntroSlider.adapter = introAdapter
        actIntroSliderBinding.indicatorTabLt.setViewPager(actIntroSliderBinding.vpIntroSlider)
        setViewPagerTimer(sliderDataList.size)

        actIntroSliderBinding.vpIntroSlider.addOnPageChangeListener(this)
    }

    private fun setViewPagerTimer(listSize:Int){
        val timer = Timer()
        timer.scheduleAtFixedRate(SliderTimer(listSize), DELAY_MS, PERIOD_MS)
    }

    internal inner class SliderTimer(val listSize:Int) : TimerTask() {
        override fun run() {
                this@IntroSliderPage.runOnUiThread {
                    if (actIntroSliderBinding.vpIntroSlider.currentItem < listSize - 1) {
                        /*fragmentHomeBinding.vpImageSlider.setCurrentItem(fragmentHomeBinding.vpImageSlider.currentItem + 1, true)*/

                        actIntroSliderBinding.vpIntroSlider.currentItem = actIntroSliderBinding.vpIntroSlider.currentItem + 1
                    } else {
                        actIntroSliderBinding.vpIntroSlider.currentItem = 0
                    }
                }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        if(position == 3){
            actIntroSliderBinding.tvNextIntroSlider.text = resources.getString(R.string.strFinish)
            actIntroSliderBinding.tvNextIntroSlider.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
        }else{
            actIntroSliderBinding.tvNextIntroSlider.text = resources.getString(R.string.strNext)
            actIntroSliderBinding.tvNextIntroSlider.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_navigate_next,0)
        }
    }

    override fun onClick(p0: View?) {
        when(p0){

            actIntroSliderBinding.clNextIntroSlider -> {
                if(actIntroSliderBinding.vpIntroSlider.currentItem == 0){
                    actIntroSliderBinding.vpIntroSlider.currentItem = 1
                }else if(actIntroSliderBinding.vpIntroSlider.currentItem == 1){
                    actIntroSliderBinding.vpIntroSlider.currentItem = 2
                }else if(actIntroSliderBinding.vpIntroSlider.currentItem == 2){
                    actIntroSliderBinding.vpIntroSlider.currentItem = 3
                }else{
//                    actIntroSliderBinding.vpIntroSlider.currentItem = 0

                    val intentLogin = Intent(this@IntroSliderPage, AuthActivity::class.java)
                    intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intentLogin)
                    finish()
                }
            }

            actIntroSliderBinding.tvSkipIntroSlider -> {
                val intentLogin = Intent(this@IntroSliderPage, AuthActivity::class.java)
                intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intentLogin)
                finish()
            }
        }
    }
}