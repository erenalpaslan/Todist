package com.erendev.todist.domain.repository

import com.erendev.todist.data.model.Task

interface TaskRepository {

    suspend fun getTasks(): List<Task>?

    suspend fun getTask(id: Int): Task?

    suspend fun getCompletedTasks(): List<Task>?

    suspend fun getOnGoingTasks(): List<Task>?

    suspend fun insertTask(task: Task?)

    suspend fun updateTask(task: Task)

    suspend fun removeTask(task: Task)

}