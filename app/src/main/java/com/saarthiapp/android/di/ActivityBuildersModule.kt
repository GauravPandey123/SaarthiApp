package com.saarthiapp.android.di

import com.saarthiapp.android.ui.activity.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector()
    abstract fun contributeActivity() : AuthActivity



}