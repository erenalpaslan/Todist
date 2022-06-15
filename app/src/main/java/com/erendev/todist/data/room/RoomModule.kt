package com.erendev.todist.data.room

import androidx.room.Room
import com.erendev.todist.common.AppConstant
import com.google.gson.Gson
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single { Gson() }
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            AppConstant.TODIST_DB_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(RoomCallback)
            .build()
    }
    single { get<AppDatabase>().taskDao() }
    single { get<AppDatabase>().categoryDao() }
}