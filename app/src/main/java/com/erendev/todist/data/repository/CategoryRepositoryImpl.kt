package com.erendev.todist.data.repository

import com.erendev.todist.data.model.Category
import com.erendev.todist.data.room.dao.CategoryDao
import com.erendev.todist.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryDao: CategoryDao
): CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        return categoryDao.getCategories()
    }

    override suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category = category)
    }

    override suspend fun removeCategory(category: Category) {
        categoryDao.removeCategory(category = category)
    }

    override suspend fun updateCategory(category: Category) {
        categoryDao.updateCategory(category = category)
    }
}