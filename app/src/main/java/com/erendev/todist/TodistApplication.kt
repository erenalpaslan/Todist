package com.erendev.todist

import android.app.Application
import com.erendev.todist.di.appModule
import com.erendev.todist.ui.screen.home.homeModule
import com.erendev.todist.ui.screen.splash.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TodistApplication: Application() {

    val moduleList = listOf(
        appModule,
        splashModule,
        homeModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TodistApplication)
            modules(moduleList)
        }
    }

}