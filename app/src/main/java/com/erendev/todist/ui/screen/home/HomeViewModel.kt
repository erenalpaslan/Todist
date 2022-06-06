package com.erendev.todist.ui.screen.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.lifecycle.viewModelScope
import com.erendev.todist.R
import com.erendev.todist.base.BaseViewModel
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task
import com.erendev.todist.ui.theme.Red
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState(tasks = listOf(
        Task(
            title = "Create TODO-list App",
            description = "Create an application which user can easily manage tasks and operate some options",
            category = Category(0, "Office", R.color.purple_200, R.drawable.ic_todo_list)
        )
    )))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onTabSelectionChanged(position: Int) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(selectedTabPosition = position)
            }
        }
    }

    fun onDelete(task: Task) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(tasks = it.tasks)
            }
        }
    }

    fun onMarkAsComplete(task: Task) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(tasks = it.tasks)
            }
        }
    }


}