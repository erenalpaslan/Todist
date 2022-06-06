package com.erendev.todist.ui.navigation.type

import android.os.Bundle
import androidx.navigation.NavType
import com.erendev.todist.data.model.Task
import com.google.gson.Gson

class TaskType: NavType<Task>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): Task? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Task {
        return Gson().fromJson(value, Task::class.javaObjectType)
    }

    override fun put(bundle: Bundle, key: String, value: Task) {
        bundle.putParcelable(key, value)
    }
}