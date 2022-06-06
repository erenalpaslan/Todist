package com.erendev.todist.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val name: String,
    val color: Int,
    val icon: Int
): Parcelable
