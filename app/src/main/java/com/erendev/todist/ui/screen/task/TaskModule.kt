package com.erendev.todist.ui.screen.task

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val taskModule = module {
    viewModel { TaskViewModel(get()) }
    factory { TaskScreen() }
}