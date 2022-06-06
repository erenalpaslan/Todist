package com.erendev.todist.ui.navigation

import androidx.annotation.StringRes

enum class Screen(val route: String) {
    Splash(route = "splash"),
    Dashboard(route = "dashboard"),
    Home(route = "home"),
    Detail(route = "detail"),
    Task(route = "task")
}