package com.erendev.todist.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Entity(tableName = "Tasks")
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String = "",
    val description: String = "",
    @Embedded val category: Category? = null,
    val startDate: Long? = null,
    val endDate: Long? = null,
    val isCompleted: Boolean = false,
    val isFinished: Boolean = false
): Parcelable
