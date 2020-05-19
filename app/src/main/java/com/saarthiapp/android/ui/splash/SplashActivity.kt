package com.saarthiapp.android.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.saarthiapp.android.R
import com.saarthiapp.android.ui.introSlider.IntroSliderPage

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleScreenForLogin()
    }

    private fun handleScreenForLogin(){
        Handler().postDelayed({
            val intentLogin = Intent(this@SplashActivity, IntroSliderPage::class.java)
            intentLogin.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentLogin)
            finish()
        }, 2000)
    }
}
