package com.erendev.todist.ui.screen.home.tab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.erendev.todist.ui.theme.Blue

@Composable
fun TabItem(
    selected: Boolean,
    name: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        if (selected) {
            Button(
                onClick = { onClick() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = name)
            }
        } else {
            OutlinedButton(
                onClick = { onClick() },
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, Blue)
            ) {
                Text(text = name)
            }
        }
    }
}