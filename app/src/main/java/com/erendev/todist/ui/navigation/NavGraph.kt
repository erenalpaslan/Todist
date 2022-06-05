package com.erendev.todist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.erendev.todist.ui.screen.home.HomeScreen
import com.erendev.todist.ui.screen.splash.SplashScreen
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            get<SplashScreen>().Create(
                viewModel = getViewModel(),
                navController = navController
            )
        }

        composable(Screen.Home.route) {
            get<HomeScreen>().Create(
                viewModel = getViewModel(),
                navController = navController
            )
        }
    }
}