package com.erendev.todist.utils

sealed class TodistResult <T> {
    data class Success <T> (val data: T?): TodistResult<T>()
    data class Error <T> (val message: String?) : TodistResult<T>()
}