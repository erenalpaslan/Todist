package com.erendev.todist.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

abstract class ITodistDispatchers {

    abstract val main: CoroutineDispatcher

    abstract val io: CoroutineDispatcher

    abstract val default: CoroutineDispatcher
}