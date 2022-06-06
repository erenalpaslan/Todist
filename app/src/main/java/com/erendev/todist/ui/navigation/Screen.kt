package com.erendev.todist.ui.navigation

import androidx.annotation.StringRes

enum class Screen(val route: String) {
    Splash(route = "splash"),
    Home(route = "Home"),
    Detail("Detail"),
    NewTask("Task"),
    Edit("Task/Edit")
}