package com.erendev.todist.di

import com.erendev.todist.utils.dispatchers.TodistDispatcher
import com.erendev.todist.utils.preferences.PreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { TodistDispatcher() }
    single { PreferencesManager(androidContext()) }
}