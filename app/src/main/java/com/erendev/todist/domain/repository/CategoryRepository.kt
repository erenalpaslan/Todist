package com.erendev.todist.domain.repository

import com.erendev.todist.data.model.Category
import com.erendev.todist.utils.TodistResult
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun getCategories(): List<Category>

    suspend fun insertCategory(category: Category)

    suspend fun removeCategory(category: Category)

    suspend fun updateCategory(category: Category)

}