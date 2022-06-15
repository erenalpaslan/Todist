package com.erendev.todist.ui.screen.task

import androidx.lifecycle.viewModelScope
import com.erendev.todist.base.BaseViewModel
import com.erendev.todist.domain.usecase.GetCategoriesUseCase
import com.erendev.todist.utils.TodistResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
): BaseViewModel() {

    private val _categories: MutableStateFlow<TaskUIState> = MutableStateFlow(TaskUIState())
    val categories: StateFlow<TaskUIState> = _categories

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            getCategoriesUseCase.execute(null).collect { result ->
                when(result) {
                    is TodistResult.Error -> _error.postValue(result.message)
                    is TodistResult.Success -> _categories.update {
                        it.copy(categories = result.data)
                    }
                }
            }
        }
    }


}