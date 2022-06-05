package com.erendev.todist.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.erendev.todist.R
import com.erendev.todist.base.BaseScreen
import com.erendev.todist.data.model.Category
import com.erendev.todist.data.model.Task
import com.erendev.todist.ui.theme.Green
import com.erendev.todist.ui.theme.Red


class HomeScreen : BaseScreen<HomeViewModel>() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    },
                    navigationIcon = {
                        IconButton(onClick = {

                        }) {
                            Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
                        }
                    },
                    modifier = Modifier.shadow(8.dp)
                )
            },
            snackbarHost = {

            },
            content = {
                HomeContent(
                    tasks = listOf(
                        Task(
                            title = "Create TO-DO app",
                            description = "You'll be building manager within jetpack compose declarative ui implementation and user can operates task  operations by the implemented features",
                            category = Category(0, "Job", Green, Icons.Rounded.MailOutline),
                            startDate = 12345L,
                            endDate = 123456L
                        ),
                        Task(
                            title = "Buy Groceries",
                            description = "This month grocery list added here!",
                            category = Category(0, "Job", Red, Icons.Rounded.Phone),
                            startDate = 12345L
                        )
                    ),
                    onTabSelectionChanged = {

                    },
                    onAddButtonClicked = {

                    }
                )
            }
        )
    }
}