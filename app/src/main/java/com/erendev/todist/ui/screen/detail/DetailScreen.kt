package com.erendev.todist.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.erendev.todist.base.BaseScreen
import com.erendev.todist.ui.theme.Red

class DetailScreen: BaseScreen<DetailViewModel>() {

    @Composable
    override fun Content() {
        Box(modifier = Modifier.background(Red)
            .fillMaxSize()) {
        }
    }

}