package com.erendev.todist.ui.screen.task

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.erendev.todist.R
import com.erendev.todist.base.BaseScreen
import com.erendev.todist.ui.theme.Green

class TaskScreen : BaseScreen<TaskViewModel>() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.task_add_page_name))
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Arrow Back")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO: Done button*/ }) {
                            Icon(imageVector = Icons.Rounded.Done, contentDescription = "Done")
                        }
                    }
                )
            },
            content = {
                TaskContent(
                    task = null,
                    viewModel = viewModel,
                    modifier = Modifier.padding(top = it.calculateTopPadding())
                )
            }
        )
    }

}