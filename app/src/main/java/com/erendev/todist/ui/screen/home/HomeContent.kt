package com.erendev.todist.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.erendev.todist.R
import com.erendev.todist.data.model.Task
import com.erendev.todist.ui.theme.Blue
import com.erendev.todist.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    tasks: List<Task>? = null,
    onTabSelectionChanged: (Int) -> Unit,
    onAddButtonClicked: () -> Unit
) {
    if (tasks.isNullOrEmpty()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_todo_list),
                contentDescription = "TODO List Icon",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.home_empty_list_title),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.home_empty_list_description),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            FilledIconButton(
                onClick = { onAddButtonClicked() },
                modifier = Modifier
                    .size(36.dp),
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add icon",
                    tint = White,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
    } else {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        onAddButtonClicked()
                    },
                    containerColor = Blue
                ) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = "Fab")
                }
            },
            content = {
                Column{
                    HomeTabs(tabs = listOf(
                        "Ongoing",
                        "Completed"
                    )) { position ->
                        onTabSelectionChanged(position)
                    }
                    LazyColumn {
                        items(tasks) { task ->  
                            TaskItem(task = task)
                        }
                    }
                }

            }
        )
    }

}