package com.erendev.todist.domain.usecase

import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCategoriesUseCase(get(), get()) }
    factory { InsertTaskUseCase(get(), get()) }
}