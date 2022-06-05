package com.erendev.todist.data.model

data class Task(
    val title: String = "",
    val description: String = "",
    val category: Category? = null,
    val startDate: Long? = null,
    val endDate: Long? = null
)
