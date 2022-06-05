package com.erendev.todist.utils.preferences

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferencesKeys {
    const val PREFERENCES_NAME = "TODIST_PREFERENCES"
    val IS_FIRST_ENTER = booleanPreferencesKey("IS_FIRST_ENTER")
}