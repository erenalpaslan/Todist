package com.erendev.todist.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task
import com.erendev.todist.ui.theme.Blue
import com.erendev.todist.ui.theme.Green
import com.erendev.todist.ui.theme.Red

@Composable
fun TaskItem(
    task: Task
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.CenterVertically, unbounded = true)
            .padding(horizontal = 16.dp)
            .height(IntrinsicSize.Min)
    ) {
        Box(modifier = Modifier.fillMaxHeight(),
        contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(task.category?.color ?: Blue)
                    .padding(10.dp)
            ) {
                Image(
                    imageVector = task.category?.icon ?: Icons.Rounded.Close,
                    contentDescription = "",
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
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "More Vertical")
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}