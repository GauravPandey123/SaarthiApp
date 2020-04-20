package com.saarthiapp.android.di

import SessionManager
import android.app.Application
import com.offline.android.di.AppModule
import com.saarthiapp.android.SaarthiApplication
import com.saarthiapp.android.di.ActivityBuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }
    fun inject(app: SaarthiApplication)

}