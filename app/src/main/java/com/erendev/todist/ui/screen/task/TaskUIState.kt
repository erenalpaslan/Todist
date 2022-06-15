package com.erendev.todist.ui.screen.task

import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task

data class TaskUIState(
    val task: Task? = null,
    val categories: List<Category>? = null,
)
