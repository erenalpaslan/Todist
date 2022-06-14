package com.erendev.todist.ui.screen.home.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.erendev.todist.R
import com.erendev.todist.data.model.Task
import com.erendev.todist.ui.theme.Blue

@Composable
fun TaskItem(
    task: Task,
    onClick: () -> Unit,
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    onCompleteClicked: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.CenterVertically, unbounded = true)
            .padding(horizontal = 16.dp)
            .height(IntrinsicSize.Min)
            .clickable {
                onClick()
            }
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(colorResource(id = task.category?.color ?: R.color.blue))
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = task.category?.icon ?: R.drawable.ic_todo_list),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .weight(1f)
        ) {
            Text(text = task.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = task.description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "${task.startDate} - ${task.endDate}",
            )
        }

        Column(
            verticalArrangement = Arrangement.Top
        ) {
            IconButton(onClick = { expanded = true }) {
                Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "More Vertical")
            }

            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }) {
                listOf(
                    stringResource(id = R.string.home_item_drop_down_edit),
                    stringResource(id = R.string.home_item_drop_down_delete),
                    stringResource(id = R.string.home_item_drop_down_mark_as_complete)
                ).forEachIndexed { index, s ->
                    DropdownMenuItem(
                        text = {
                            Text(text = s)
                        },
                        onClick = {
                            expanded = false
                            when (index) {
                                0 -> onEditClicked()
                                1 -> onDeleteClicked()
                                2 -> onCompleteClicked()
                            }
                        })
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}