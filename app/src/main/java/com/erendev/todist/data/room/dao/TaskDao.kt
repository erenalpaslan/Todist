package com.erendev.todist.data.room.dao

import androidx.room.*
import com.erendev.todist.data.model.Task

@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task?)

    @Delete
    suspend fun removeTask(task: Task?)

    @Query("SELECT * FROM Tasks")
    suspend fun getAllTasks(): List<Task>?

    @Query("SELECT * FROM Tasks WHERE isCompleted == 1")
    suspend fun getCompletedTasks(): List<Task>?

    @Query("SELECT * FROM Tasks WHERE isCompleted == 0 AND isFinished == 0")
    suspend fun getOngoingTasks(): List<Task>?

    @Query("SELECT * FROM Tasks WHERE id == :id")
    suspend fun getTask(id: Int): Task?
}