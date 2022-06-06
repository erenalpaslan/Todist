package com.erendev.todist.data.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Task(
    val title: String = "",
    val description: String = "",
    val category: Category? = null,
    val startDate: Long? = null,
    val endDate: Long? = null
): Parcelable
