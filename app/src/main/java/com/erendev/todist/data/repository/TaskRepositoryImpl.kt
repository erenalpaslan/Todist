package com.erendev.todist.data.repository

import com.erendev.todist.data.model.Task
import com.erendev.todist.data.room.dao.TaskDao
import com.erendev.todist.domain.repository.TaskRepository

class TaskRepositoryImpl(
    private val taskDao: TaskDao
): TaskRepository {

    override suspend fun getTasks(): List<Task>? {
        return taskDao.getAllTasks()
    }

    override suspend fun getTask(id: Int): Task? {
        return taskDao.getTask(id)
    }

    override suspend fun getCompletedTasks(): List<Task>? {
        return taskDao.getCompletedTasks()
    }

    override suspend fun getOnGoingTasks(): List<Task>? {
        return taskDao.getOngoingTasks()
    }

    override suspend fun insertTask(task: Task?) {
        taskDao.insertTask(task)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    override suspend fun removeTask(task: Task) {
        taskDao.removeTask(task)
    }
}