package com.erendev.todist.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.erendev.todist.data.model.Category

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun removeCategory(category: Category?)

}