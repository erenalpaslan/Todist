package com.erendev.todist.ui.screen.home.content

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.erendev.todist.ui.navigation.Screen
import com.erendev.todist.ui.screen.home.HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeContent(
    navController: NavController,
    viewModel: HomeViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.tasks.isNullOrEmpty()) {
        HomeEmptyContent {
            navController.navigate(Screen.Task.route)
        }
    } else {
        HomeTaskList(
            tasks = uiState.tasks,
            selectedTabIndex = uiState.selectedTabPosition,
            viewModel = viewModel,
            navController = navController
        )
    }

}