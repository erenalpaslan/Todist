package com.erendev.todist.ui.screen.task

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.erendev.todist.data.model.Task
import com.erendev.todist.R
import com.erendev.todist.ui.MainActivity
import com.erendev.todist.ui.screen.view.DatePicker
import com.erendev.todist.ui.theme.Blue
import com.erendev.todist.ui.theme.Gray
import com.google.android.material.datepicker.MaterialDatePicker

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

    var showCategoryDropDown by remember {
        mutableStateOf(false)
    }

    var categoryDropDownSelection by remember {
        mutableStateOf<String?>(null)
    }

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    if (showDatePicker) {
        DatePicker(onDismissRequest = {
            showDatePicker = false
        }) { dateString ->
            date = dateString
            Log.d("DateControl", "=> $dateString")
            showDatePicker = false
        }
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
        Column() {
            Box {
                OutlinedTextField(
                    value = categoryDropDownSelection ?: "",
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = {
                        Text(text = stringResource(id = R.string.task_category_placeholder))
                    },
                    onValueChange = {
                        category = it
                    },
                    readOnly = true,
                    trailingIcon = {
                        Icon(imageVector = Icons.Rounded.ArrowDropDown, contentDescription = "")
                    }
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable {
                        showCategoryDropDown = true
                        Log.d("TaskContent", "=> $showCategoryDropDown")
                    }) {

                }
            }
            DropdownMenu(
                expanded = showCategoryDropDown,
                onDismissRequest = { showCategoryDropDown = false }) {
                DropdownMenuItem(text = { Text(text = "Office") }, onClick = {
                    showCategoryDropDown = false
                    categoryDropDownSelection = "Office"
                })
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = description,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3,
            placeholder = {
                Text(text = stringResource(id = R.string.task_description_placeholder))
            },
            onValueChange = {
                description = it
            })
        Spacer(modifier = Modifier.height(16.dp))
        Box {
            OutlinedTextField(
                value = date,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = stringResource(id = R.string.task_add_date_placeholder))
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.DateRange,
                        contentDescription = "Date",
                        tint = if (date.isNotEmpty()) Blue else Gray
                    )
                },
                onValueChange = {
                    date = it
                },
                readOnly = true,
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable {
                    showDatePicker = true
                }) {
            }
        }
    }
}