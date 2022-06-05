package com.erendev.todist.utils.preferences

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Implementation of the data store
 */
class PreferencesManager(private val context: Context) {

    companion object {
        private val Context.dataStore by preferencesDataStore(
            name = PreferencesKeys.PREFERENCES_NAME
        )
    }

    fun getBoolean(
        key: Preferences.Key<Boolean>,
        defaultValue: Boolean = true
    ): Flow<Boolean> = context.dataStore.data.map {
        it[key] ?: defaultValue
    }

    suspend fun setBoolean(key: Preferences.Key<Boolean>, value: Boolean) {
        context.dataStore.edit { it[key] = value }
    }

}