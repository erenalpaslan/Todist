package com.erendev.todist.ui.screen.home.content

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erendev.todist.R
import com.erendev.todist.data.model.Task
import com.erendev.todist.ui.navigation.Screen
import com.erendev.todist.ui.screen.home.HomeViewModel
import com.erendev.todist.ui.screen.home.tab.HomeTabs
import com.erendev.todist.ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeTaskList(
    tasks: List<Task>?,
    viewModel: HomeViewModel,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.Task.route)
                },
                containerColor = Blue
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Fab")
            }
        },
        content = {
            Column {
                HomeTabs(
                    tabs = listOf(
                        stringResource(id = R.string.home_tab_ongoing),
                        stringResource(id = R.string.home_tab_completed)
                    )
                ) { position ->
                    viewModel.onTabSelectionChanged(position)
                }
                LazyColumn {
                    tasks?.let {
                        items(it) { task ->
                            TaskItem(
                                task = task,
                                onClick = {
                                    navController.navigate(Screen.Detail.route)
                                },
                                onEditClicked = {
                                    navController.navigate(Screen.Task.route)
                                },
                                onDeleteClicked = {
                                    viewModel.onDelete(task)
                                },
                                onCompleteClicked = {
                                    viewModel.onMarkAsComplete(task)
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}