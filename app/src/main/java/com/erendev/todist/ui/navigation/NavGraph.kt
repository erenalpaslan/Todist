package com.erendev.todist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.erendev.todist.ui.screen.detail.DetailScreen
import com.erendev.todist.ui.screen.home.HomeScreen
import com.erendev.todist.ui.screen.splash.SplashScreen
import com.erendev.todist.ui.screen.task.TaskScreen
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

        navigation(
            startDestination = Screen.Home.route,
            route = Screen.Dashboard.route
        ) {
            composable(Screen.Home.route) {
                get<HomeScreen>().Create(
                    viewModel = getViewModel(),
                    navController = navController
                )
            }

            composable(Screen.Detail.route) {
                get<DetailScreen>().Create(
                    viewModel = getViewModel(),
                    navController = navController
                )
            }

            composable(Screen.Task.route) {
                get<TaskScreen>().Create(
                    viewModel = getViewModel(),
                    navController = navController
                )
            }
        }
    }
}