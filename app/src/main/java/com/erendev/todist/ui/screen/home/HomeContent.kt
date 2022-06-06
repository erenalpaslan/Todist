package com.erendev.todist.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.erendev.todist.R
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task
import com.erendev.todist.ui.navigation.Screen
import com.erendev.todist.ui.theme.Blue
import com.erendev.todist.ui.theme.Green
import com.erendev.todist.ui.theme.Red
import com.erendev.todist.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    navController: NavController,
    viewModel: HomeViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.tasks.isNullOrEmpty()) {
        HomeEmptyContent {
            navController.navigate(Screen.NewTask.route)
        }
    } else {
        HomeTaskList(
            tasks = uiState.tasks,
            viewModel = viewModel,
            navController = navController
        )
    }

}