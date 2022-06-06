package com.erendev.todist.ui.screen.home.tab

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeTabs(
    tabs: List<String> = emptyList(),
    onTabSelected: (Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.padding(vertical = 10.dp),
        indicator = {
        },
        divider = {
        }
    ) {
        tabs.forEachIndexed { index, name ->
            TabItem(
                selected = index == selectedTabIndex,
                name = name,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            )
        }
    }
}