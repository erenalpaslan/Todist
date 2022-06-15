package com.erendev.todist.ui.screen.home

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.lifecycle.viewModelScope
import com.erendev.todist.R
import com.erendev.todist.base.BaseViewModel
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task
import com.erendev.todist.domain.usecase.GetCompletedTasksUseCase
import com.erendev.todist.domain.usecase.GetOnGoingUseCase
import com.erendev.todist.ui.theme.Red
import com.erendev.todist.utils.TodistResult
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCompletedTasksUseCase: GetCompletedTasksUseCase,
    private val getOnGoingUseCase: GetOnGoingUseCase
) : BaseViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getTasks(0)
    }

    fun onTabSelectionChanged(position: Int) {
        viewModelScope.launch {
           _uiState.update {
               it.copy(selectedTabPosition = position)
           }
           getTasks(position)
        }
    }

    fun getTasks(position: Int) {
        viewModelScope.launch {
            val useCase = if (position == 0) getOnGoingUseCase else getCompletedTasksUseCase
            useCase.execute(null).collect { result ->
                when (result) {
                    is TodistResult.Error -> _error.postValue(result.message)
                    is TodistResult.Success -> {
                        Log.d("ResultControl", "=> $result")
                        _uiState.update {
                            it.copy(
                                selectedTabPosition = position,
                                tasks = result.data
                            )
                        }
                    }
                }
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