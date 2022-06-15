package com.erendev.todist.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.erendev.todist.data.model.Category

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun removeCategory(category: Category?)

    @Update
    suspend fun updateCategory(category: Category)

    @Query("SELECT * FROM Categories")
    suspend fun getCategories(): List<Category>

}