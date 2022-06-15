package com.erendev.todist.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavOptions
import com.erendev.todist.R
import com.erendev.todist.base.BaseScreen
import com.erendev.todist.ui.navigation.Screen
import com.erendev.todist.ui.theme.Green
import kotlinx.coroutines.delay

class SplashScreen : BaseScreen<SplashViewModel>() {

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_background
                ),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(12.dp)),
            )
        }

        LaunchedEffect(key1 = "") {
            delay(1000L)
            navController.navigate(
                Screen.Home.route, NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .setPopUpTo(Screen.Splash.route, true)
                    .build()
            )
        }
    }

}