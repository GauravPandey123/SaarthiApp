package com.saarthiapp.android.application

import android.app.Activity
import android.app.Application
import androidx.multidex.MultiDexApplication
import com.saarthiapp.android.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class SaarthiApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)

    }

    override fun activityInjector() = dispatchingAndroidInjector

}