package com.erendev.todist.data.repository

import com.erendev.todist.domain.repository.CategoryRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<CategoryRepository> { CategoryRepositoryImpl(get()) }
}