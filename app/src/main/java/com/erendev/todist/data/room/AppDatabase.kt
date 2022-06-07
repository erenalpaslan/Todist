package com.erendev.todist.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erendev.todist.BuildConfig
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task
import com.erendev.todist.data.room.dao.CategoryDao
import com.erendev.todist.data.room.dao.TaskDao


@Database(
    entities = [
        Task::class,
        Category::class
    ],
    version = BuildConfig.VERSION_CODE
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun categoryDao(): CategoryDao
}
