package com.erendev.todist

import android.app.Application
import com.erendev.todist.data.room.roomModule
import com.erendev.todist.di.appModule
import com.erendev.todist.ui.screen.detail.detailModule
import com.erendev.todist.ui.screen.home.homeModule
import com.erendev.todist.ui.screen.splash.splashModule
import com.erendev.todist.ui.screen.task.taskModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TodistApplication: Application() {

    private val moduleList = listOf(
        appModule,
        splashModule,
        homeModule,
        detailModule,
        taskModule,
        roomModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TodistApplication)
            modules(moduleList)
        }
    }

}