package com.erendev.todist.data.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val id: Int,
    val name: String,
    val color: Color,
    val icon: ImageVector
)
