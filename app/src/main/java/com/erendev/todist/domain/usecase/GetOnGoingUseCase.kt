package com.erendev.todist.domain.usecase

import com.erendev.todist.base.BaseUseCase
import com.erendev.todist.data.model.Task
import com.erendev.todist.domain.repository.TaskRepository
import com.erendev.todist.utils.TodistResult
import com.erendev.todist.utils.dispatchers.TodistDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetOnGoingUseCase(
    private val taskRepository: TaskRepository,
    private val dispatcher: TodistDispatcher
): BaseUseCase<List<Task>, Any>() {
    override suspend fun execute(params: Any?): Flow<TodistResult<List<Task>>> =
        flow {
            try {
                val tasks = taskRepository.getOnGoingTasks()
                emit(TodistResult.Success(tasks))
            }catch (e: Exception) {
                emit(TodistResult.Error(e.message))
            }
        }.flowOn(dispatcher.io)
}