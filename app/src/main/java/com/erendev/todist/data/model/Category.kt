package com.erendev.todist.data.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Categories")
@Parcelize
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Int = 0,
    val name: String,
    @ColorRes val color: Int,
    @DrawableRes val icon: Int
): Parcelable
