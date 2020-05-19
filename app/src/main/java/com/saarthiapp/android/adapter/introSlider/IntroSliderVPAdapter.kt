package com.saarthiapp.android.adapter.introSlider

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.saarthiapp.android.R
import com.saarthiapp.android.model.introSlider.IntroSliderData

class IntroSliderVPAdapter(
    val mCtx: Context,
    val sliderDataList: ArrayList<IntroSliderData>
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        Log.e("slider size", " :: ${sliderDataList.size}")
        return sliderDataList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.intro_slider_item_layout, null)

        val sliderDataModel = sliderDataList[position]
        val imgSlider: ImageView = view.findViewById(R.id.imgIntroSlider)
        val tvIntroTitle: TextView = view.findViewById(R.id.tvIntroTitle)
        val tvIntroDesc: TextView = view.findViewById(R.id.tvIntroDesc)

        Glide.with(mCtx).load(sliderDataModel.imgID).into(imgSlider)
        tvIntroTitle.text = sliderDataModel.title
        tvIntroDesc.text = sliderDataModel.desc

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}