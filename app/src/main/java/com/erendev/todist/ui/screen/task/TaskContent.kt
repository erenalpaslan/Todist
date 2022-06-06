package com.erendev.todist.ui.screen.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.erendev.todist.data.model.Task
import com.erendev.todist.R
import com.erendev.todist.ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskContent(
    task: Task? = null,
    viewModel: TaskViewModel,
    modifier: Modifier
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var category by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableStateOf("")
    }

    var shouldRemind by remember {
        mutableStateOf(false)
    }

    var showDropDown by remember {
        mutableStateOf(false)
    }

    var dropDownSelection by remember {
        mutableStateOf("1 hour before")
    }

    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            placeholder = {
                Text(text = stringResource(id = R.string.task_title_placeholder))
            },
            onValueChange = {
                title = it
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = category,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(id = R.string.task_category_placeholder))
            },
            onValueChange = {
                category = it
            })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = description,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(id = R.string.task_description_placeholder))
            },
            onValueChange = {
                description = it
            })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = date,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(id = R.string.task_add_date_placeholder))
            },
            onValueChange = {
                date = it
            })
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = shouldRemind,
                    onCheckedChange = {
                        shouldRemind = it
                    }
                )
                Text(text = stringResource(id = R.string.task_remind_me_title))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = dropDownSelection, color = Blue)
                IconButton(onClick = { showDropDown = true }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropDown,
                        contentDescription = "Dropdown icon",
                        tint = Blue
                    )
                }
                DropdownMenu(expanded = showDropDown, onDismissRequest = { showDropDown = false }) {
                    DropdownMenuItem(text = { Text(text = "2 hour before") }, onClick = {
                        showDropDown = false
                        dropDownSelection = "2 hour before"
                    })
                }
            }
        }
    }
}