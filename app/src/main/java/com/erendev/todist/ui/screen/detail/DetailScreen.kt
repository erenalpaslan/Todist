package com.erendev.todist.ui.screen.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.erendev.todist.base.BaseScreen
import com.erendev.todist.data.model.Task
import com.erendev.todist.R

class DetailScreen : BaseScreen<DetailViewModel>() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun Content() {
        val task by remember {
            mutableStateOf<Task?>(navController.currentBackStackEntry?.arguments?.getParcelable("task"))
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.detail_task_page_name))
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            task?.let {
                                viewModel.onEdit(it)
                            }
                        }) {
                            Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Edit")
                        }
                        IconButton(onClick = {
                            task?.let {
                                viewModel.onDelete(it)
                            }
                        }) {
                            Icon(imageVector = Icons.Rounded.Delete, contentDescription = "Edit")
                        }
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = it.calculateTopPadding())
                        .padding(16.dp)
                ) {
                    Text(text = task?.title ?: "", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.detail_description_title),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = task?.description ?: "")
                    Spacer(modifier = Modifier.height(20.dp))
                    if (task?.startDate != null) {
                        Text(
                            text = stringResource(id = R.string.detail_due_date_title),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(text = "${task?.startDate} - ${task?.endDate}")
                    }
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            task?.let {
                                viewModel.onMarkAsComplete(it)
                            }
                        }) {
                            Text(text = stringResource(id = R.string.detail_mark_as_completed))
                        }
                    }
                }
            }
        )
    }

}