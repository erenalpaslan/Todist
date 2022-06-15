package com.erendev.todist.base

import com.erendev.todist.utils.TodistResult
import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<T : Any, in Params> {
    abstract suspend fun execute(params: Params?): Flow<TodistResult<T>>
}