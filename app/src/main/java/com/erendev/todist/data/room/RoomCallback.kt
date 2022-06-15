package com.erendev.todist.data.room

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.erendev.todist.R
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.room.dao.CategoryDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object RoomCallback: RoomDatabase.Callback(), KoinComponent {

    private val categoryDao: CategoryDao by inject()

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        CoroutineScope(Dispatchers.IO).launch {
            categoryDao.insertCategory(category = Category(
                categoryId = 1,
                name = "Office",
                color = R.color.blue,
                icon = R.drawable.ic_work
            ))
            categoryDao.insertCategory(category = Category(
                categoryId = 2,
                name = "Market",
                color = R.color.red,
                icon = R.drawable.ic_shopping
            ))
            categoryDao.insertCategory(category = Category(
                categoryId = 3,
                name = "TO-DO List Application",
                color = R.color.green,
                icon = R.drawable.ic_develop
            ))
        }
    }
}