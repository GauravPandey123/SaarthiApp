package com.saarthiapp.android.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ActivityCollapsingToolbarPageBinding

class CollapsingToolbarPage : AppCompatActivity() {

    private lateinit var collapsingToolbarBinding:ActivityCollapsingToolbarPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collapsingToolbarBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_collapsing_toolbar_page)
        setSupportActionBar(collapsingToolbarBinding.mtbCollapsing)
    }
}
