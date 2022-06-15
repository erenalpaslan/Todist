package com.erendev.todist.domain.usecase

import com.erendev.todist.base.BaseUseCase
import com.erendev.todist.data.model.Category
import com.erendev.todist.domain.repository.CategoryRepository
import com.erendev.todist.utils.TodistResult
import com.erendev.todist.utils.dispatchers.TodistDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCategoriesUseCase(
    private val categoryRepository: CategoryRepository,
    private val todistDispatcher: TodistDispatcher
) : BaseUseCase<List<Category>, Any>() {

    override suspend fun execute(params: Any?): Flow<TodistResult<List<Category>>> =
        flow {
            try {
                val categories = categoryRepository.getCategories()
                emit(TodistResult.Success(data = categories))
            }catch (e: Exception) {
                emit(TodistResult.Error(e.message))
            }
        }.flowOn(todistDispatcher.io)

}