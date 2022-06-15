package com.erendev.todist.ui.screen.task

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.erendev.todist.base.BaseViewModel
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task
import com.erendev.todist.domain.usecase.GetCategoriesUseCase
import com.erendev.todist.domain.usecase.InsertTaskUseCase
import com.erendev.todist.utils.TodistResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskViewModel(
    private val handle: SavedStateHandle,
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val insertTaskUseCase: InsertTaskUseCase
): BaseViewModel() {

    private val task: Task = handle["task"] ?: Task()

    private val _uiState: MutableStateFlow<TaskUIState> = MutableStateFlow(TaskUIState())
    val uiState: StateFlow<TaskUIState> = _uiState.asStateFlow()

    private val _onDoneSucceeded: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val onDoneSucceeded: StateFlow<Boolean> = _onDoneSucceeded.asStateFlow()

    init {
        getCategories()
    }

    fun setTitle(title: String) {
        task.title = title
    }

    fun setCategory(category: Category) {
        task.category = category
    }

    fun setDescription(desc: String) {
        task.description = desc
    }

    fun setDate(date: String) {
        task.date = date
    }


    private fun getCategories() {
        viewModelScope.launch {
            getCategoriesUseCase.execute(null).collect { result ->
                when(result) {
                    is TodistResult.Error -> _error.postValue(result.message)
                    is TodistResult.Success -> _uiState.update {
                        it.copy(categories = result.data)
                    }
                }
            }
        }
    }

    fun onDoneClicked() {
        viewModelScope.launch {
            insertTaskUseCase.execute(InsertTaskUseCase.Param(task = task)).collect{ result ->
                when(result) {
                    is TodistResult.Error -> _error.postValue(result.message)
                    is TodistResult.Success -> _onDoneSucceeded.update {
                        result.data ?: false
                    }
                }
            }
        }
    }

}