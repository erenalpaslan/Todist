package com.erendev.todist.domain.usecase

import com.erendev.todist.base.BaseUseCase
import com.erendev.todist.data.model.Task
import com.erendev.todist.domain.repository.TaskRepository
import com.erendev.todist.utils.TodistResult
import com.erendev.todist.utils.dispatchers.TodistDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class InsertTaskUseCase(
    private val taskRepository: TaskRepository,
    private val dispatcher: TodistDispatcher
): BaseUseCase<Boolean, InsertTaskUseCase.Param>() {

    data class Param(
        val task: Task
    )

    override suspend fun execute(params: Param?): Flow<TodistResult<Boolean>> =
        flow {
            try {
                taskRepository.insertTask(params?.task)
                emit(TodistResult.Success(true))
            }catch (e: Exception) {
                emit(TodistResult.Error(e.message))
            }
        }.flowOn(dispatcher.io)

}