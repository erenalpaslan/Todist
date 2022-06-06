package com.erendev.todist.ui.screen.home

import com.erendev.todist.data.model.Task

data class HomeUiState(
    val selectedTabPosition: Int = 0,
    val tasks: List<Task>? = null,
)
