package com.erendev.todist.data.repository

import com.erendev.todist.domain.repository.CategoryRepository
import com.erendev.todist.domain.repository.TaskRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<CategoryRepository> { CategoryRepositoryImpl(get()) }
    factory<TaskRepository> { TaskRepositoryImpl(get()) }
}