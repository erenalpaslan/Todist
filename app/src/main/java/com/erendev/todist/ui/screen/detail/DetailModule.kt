package com.erendev.todist.ui.screen.detail

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    viewModel { DetailViewModel() }
    factory { DetailScreen() }
}